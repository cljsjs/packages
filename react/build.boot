(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "15.2.1")
(def +version+ (str +lib-version+ "-1"))

(def checksums
  {'cljsjs/react
   {:dev "aa4a8181f5a6c5e1f85cd64d9d44c35e",
    :min "a4137323c75e65beca5a3ca602d78a87"},
   'cljsjs/react-with-addons
   {:dev "27900448a11ba98934e730ecb1cc2456",
    :min "5de9819d7571ee9fe69ea3223070a811"},
   'cljsjs/react-dom
   {:dev "2e080fa41ffcf3588f378af01485c09a",
    :min "981fd81aa9e74564eadc59331f03e23c"},
   'cljsjs/react-dom-server
   {:dev "e267bd8d0554acdb7cb936c16897dc84",
    :min "557fc431e6304c1ffb819dbbae1bc80b"}})

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
