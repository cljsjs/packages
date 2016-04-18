(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "15.0.1")
(def +version+ (str +lib-version+ "-1"))

(def checksums
  {'cljsjs/react
   {:dev "E4752B6AF074C6D4D204E930E092A6BC",
    :min "075A24757DDF994EE088AE96F4D5682E"},
   'cljsjs/react-with-addons
   {:dev "777EB46EDC785C0D6F250CF7E511F205",
    :min "8BD6C5D25FE70E1296C4141483F5F845"},
   'cljsjs/react-dom
   {:dev "380D8646723F8FC01288E74C683D8E64",
    :min "E714DF9295D8FF0C1B4D6D84EAF0B2B7"},
   'cljsjs/react-dom-server
   {:dev "D7B9CFCE04DE4391927B33875B8EB0B3",
    :min "EEF359E6F0D740FE3C3E908365FFDCAC"}})

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
