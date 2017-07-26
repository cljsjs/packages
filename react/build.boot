(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[clojure.java.io     :as io]
         '[clojure.string :as str])

(def +lib-version+ "15.6.1")
(def +version+ (str +lib-version+ "-0"))

(def checksums
  {'cljsjs/react
   {:dev "9D6C35A307DB61A32D0D831187622ABE",
    :min "6EDAD0B09347612195C91E053C8AA038"},
   'cljsjs/react-with-addons
   {:dev "BA4A1AF5E39A95B1D44827EED5F3258F",
    :min "0800F9FC2EA2688A0F31B89C5B5D68D0"},
   'cljsjs/react-dom
   {:dev "8838F58E46DF136892903541A90DFD18",
    :min "86FCB75992CFC47204ED9A2DAC56860E"},
   'cljsjs/react-dom-server
   {:dev "68A97E8D961E6C203528B5A0B20E7B78",
    :min "EBFA1A1C8670FE63BF839F51CEF61473"}})

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

(deftask surrogate
  "Creates an empty surrogate js fies"
  [f filename FILENAME str "File name"
   p project  PROJECT  sym "Project"]
  (let [tmp    (tmp-dir!)
        target (io/file tmp filename)]
    (with-pre-wrap fileset
      (io/make-parents target)
      (spit target (str "// Surrogate package for "
                        (str/replace (name project) #"-surrogate$" "")))
      (-> fileset
          (add-resource tmp)
          commit!))))

(defn package-part [{:keys [extern-name namespace project dependencies requires surrogate?]}]
  (with-files (fn [x] (= extern-name (.getName (tmp-file x))))
    (comp
     (if surrogate?
       (surrogate :filename (format "cljsjs/%1$s/development/%1$s.inc.js" (name project))
                  :project project)
       (comp
        (download :url (format "https://unpkg.com/%s@%s/dist/%s.js" (npm-project project) +lib-version+ (name project))
                  :checksum (:dev (get checksums project)))
        (download :url (format "https://unpkg.com/%s@%s/dist/%s.min.js" (npm-project project) +lib-version+ (name project))
                  :checksum (:min (get checksums project)))
        (sift :move {(re-pattern (format "^%s.js$" (name project)))     (format "cljsjs/%1$s/development/%1$s.inc.js" (name project))
                     (re-pattern (format "^%s.min.js$" (name project))) (format "cljsjs/%1$s/production/%1$s.min.inc.js" (name project))})))
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

(deftask package-react-surrogate []
  (package-part
   {:extern-name "react.ext.js"
    :namespace "cljsjs.react"
    :project 'cljsjs/react-surrogate
    :surrogate? true}))

(deftask package-dom-surrogate []
  (package-part
   {:extern-name "react-dom.ext.js"
    :namespace "cljsjs.react.dom"
    :project 'cljsjs/react-dom-surrogate
    :surrogate? true}))

(deftask package-dom-server-surrogate []
  (package-part
   {:extern-name "react-dom-server.ext.js"
    :namespace "cljsjs.react.dom.server"
    :project 'cljsjs/react-dom-server-surrogate
    :surrogate? true}))

(deftask package []
  (comp
    (package-react)
    (package-react-surrogate)
    (package-dom)
    (package-dom-surrogate)
    (package-dom-server)
    (package-dom-server-surrogate)
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
