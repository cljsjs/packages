(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.14.6")
(def +version+ (str +lib-version+ "-0"))

(def checksums
  {'cljsjs/react
   {:dev "BB2C62121CB5F65F73DEA3FBCE3137BF",
    :min "E7476F6D44EE6EA712186F06E47654F2"},
   'cljsjs/react-with-addons
   {:dev "F90DAEE0F05255CCBE61F496F85DBF9B",
    :min "D571B9DA68D2F6F19ECCEFE7F1E463FE"},
   'cljsjs/react-dom
   {:dev "E8D6BA1A79D1E930DDDA8B9AB0F1CE17",
    :min "6C184AF179AB8F740E1DB496046DC8B7"},
   'cljsjs/react-dom-server
   {:dev "009356BE32349F8E53277377FF40D822",
    :min "3C97085EC2B76208D11720A0D3CFEA82"}})

(task-options!
 pom  {:project     'cljsjs/react
       :version     +version+
       :description "A Javascript library for building user interfaces"
       :url         "http://facebook.github.io/react/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

;; TODO: Should eventually be included in boot.core
(defn with-files
  "Runs middleware with filtered fileset and merges the result back into complete fileset."
  [p middleware]
  (fn [next-handler]
    (fn [fileset]
      (let [merge-fileset-handler (fn [fileset']
                                    (next-handler (commit! (assoc fileset :tree (merge (:tree fileset) (:tree fileset'))))))
            handler (middleware merge-fileset-handler)
            fileset (assoc fileset :tree (reduce-kv
                                          (fn [tree path x]
                                            (if (p x)
                                              (assoc tree path x)
                                              tree))
                                          (empty (:tree fileset))
                                          (:tree fileset)))]
        (handler fileset)))))

(defn package-part [{:keys [extern-name namespace project dependencies requires]}]
  (with-files (fn [x] (= extern-name (.getName (tmp-file x))))
    (comp
      (download :url (format "http://fb.me/%s-%s.js" (name project) +lib-version+)
                :checksum (:dev (get checksums project)))
      (download :url (format "http://fb.me/%s-%s.min.js" (name project) +lib-version+)
                :checksum (:min (get checksums project)))
      (sift :move {(re-pattern (format "^%s-%s.js$" (name project) +lib-version+))     (format "cljsjs/%1$s/development/%1$s.inc.js" (name project))
                   (re-pattern (format "^%s-%s.min.js$" (name project) +lib-version+)) (format "cljsjs/%1$s/production/%1$s.min.inc.js" (name project))})
      (sift :include #{#"^cljsjs"})
      (deps-cljs :name namespace :requires requires)
      (pom :project project :dependencies (or dependencies []))
      (jar))))

(deftask package-react []
  (package-part
    {:extern-name "react.ext.js"
     :namespace "cljsjs.react"
     :project 'cljsjs/react}))

(deftask package-dom []
  (package-part
    {:extern-name "react-dom.ext.js"
     :namespace "cljsjs.react.dom"
     :requires ["cljsjs.react"]
     :project 'cljsjs/react-dom
     :dependencies [['cljsjs/react +version+]]}))

(deftask package-dom-server []
  (package-part
    {:extern-name "react-dom-server.ext.js"
     :namespace "cljsjs.react.dom.server"
     :requires ["cljsjs.react"]
     :project 'cljsjs/react-dom-server
     :dependencies [['cljsjs/react +version+]]}))

(deftask package-with-addons []
  (package-part
    {:extern-name "react.ext.js"
     :namespace "cljsjs.react"
     :project 'cljsjs/react-with-addons}))

(deftask package []
  (comp
    (package-react)
    (package-dom)
    (package-dom-server)
    (package-with-addons)))


(defn md5sum [fileset name]
  (with-open [is  (clojure.java.io/input-stream (tmp-file (tmp-get fileset name)))
              dis (java.security.DigestInputStream. is (java.security.MessageDigest/getInstance "MD5"))]
    (#'cljsjs.boot-cljsjs.packaging/realize-input-stream! dis)
    (#'cljsjs.boot-cljsjs.packaging/message-digest->str (.getMessageDigest dis))))

(deftask load-checksums
  "Task to create checksums map for new version"
  []
  (comp
    (reduce
      (fn [handler project]
        (comp handler
              (download :url (format "http://fb.me/%s-%s.js" (name project) +lib-version+))
              (download :url (format "http://fb.me/%s-%s.min.js" (name project) +lib-version+))))
      identity
      (keys checksums))
    (fn [handler]
      (fn [fileset]
        (clojure.pprint/pprint (into {} (map (juxt identity (fn [project]
                                                              {:dev (md5sum fileset (format "%s-%s.js" (name project) +lib-version+))
                                                               :min (md5sum fileset (format "%s-%s.min.js" (name project) +lib-version+))}))
                                             (keys checksums))))
        fileset))))
