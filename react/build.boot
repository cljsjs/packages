(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "15.6.0")
(def +version+ (str +lib-version+ "-1"))

(def checksums
  {'cljsjs/react
   {:dev "D4F4B594AE9FC2F5B36486D074AF010F",
    :min "14B9CCA6F002450560022FAFB3677F9B"},
   'cljsjs/react-with-addons
   {:dev "C111586A68CBD27553E4003FD18A6679",
    :min "CCD8D962C5C8BD6C53105EAF52F38F87"},
   'cljsjs/react-dom
   {:dev "BD644C4776F95EF5C392D1844F90F187",
    :min "1448D1597AF127FD228272ED2782F6EE"},
   'cljsjs/react-dom-server
   {:dev "994AFCA31107DF179482C2EEAE345F73",
    :min "0DF148A737022B3F2BCE4DBFEB4A8111"}})

(def npm-project {'cljsjs/react "react"
                  'cljsjs/react-with-addons "react"
                  'cljsjs/react-dom "react-dom"
                  'cljsjs/react-dom-server "react-dom"})

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
      (download :url (format "https://unpkg.com/%s@%s/dist/%s.js" (npm-project project) +lib-version+ (name project))
                :checksum (:dev (get checksums project)))
      (download :url (format "https://unpkg.com/%s@%s/dist/%s.min.js" (npm-project project) +lib-version+ (name project))
                :checksum (:min (get checksums project)))
      (sift :move {(re-pattern (format "^%s.js$" (name project)))     (format "cljsjs/%1$s/development/%1$s.inc.js" (name project))
                   (re-pattern (format "^%s.min.js$" (name project))) (format "cljsjs/%1$s/production/%1$s.min.inc.js" (name project))})
      (sift :include #{#"^cljsjs"})
      (deps-cljs :name namespace :requires requires)
      (pom :project project :dependencies (or dependencies []))
      (show :fileset true)
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
              (download :url (format "https://unpkg.com/%s@%s/dist/%s.js" (npm-project project) +lib-version+ (name project)))
              (download :url (format "https://unpkg.com/%s@%s/dist/%s.min.js" (npm-project project) +lib-version+ (name project)))))
      identity
      (keys checksums))
    (fn [handler]
      (fn [fileset]
        (println
          (clojure.string/replace
            (with-out-str
              (clojure.pprint/pprint (into {} (map (juxt identity (fn [project]
                                                                    {:dev (md5sum fileset (format "%s.js" (name project)))
                                                                     :min (md5sum fileset (format "%s.min.js" (name project)))}))
                                                   (keys checksums)))))
            #"cljsjs" "'cljsjs"))
        fileset))))
