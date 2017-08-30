(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "16.0.0-beta.2")
(def +version+ (str +lib-version+ "-1"))

(def checksums
  {'cljsjs/react
   {:dev "F24B8661C004F2585B3E561AAD7248E5",
    :min "CCF7DFFF26B6121B05E79C7D263D7C1E"},
   'cljsjs/react-dom
   {:dev "8F6AAFE10488C7F77FD02C3B05ADA280",
    :min "D61FA26AB6487F46BD6C583B4C9AE08E"},
   'cljsjs/react-dom-server
   {:dev "06D46BD6B351B2D48B159938F140ACE8",
    :min "70E9D9FC5609846A137E07A21CA240EF"}})

(def npm-project {'cljsjs/react "react"
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
  (with-files (fn [x]
                (or (= extern-name (.getName (tmp-file x)))
                    (= (str (name project) "-deps.cljs") (.getName (tmp-file x)))))
    (comp
      (download :url (format "https://unpkg.com/%s@%s/umd/%s.development.js" (npm-project project) +lib-version+ (name project))
                :checksum (:dev (get checksums project)))
      (download :url (format "https://unpkg.com/%s@%s/umd/%s.production.min.js" (npm-project project) +lib-version+ (name project))
                :checksum (:min (get checksums project)))
      (sift :move {(re-pattern (format "^%s.development.js$" (name project)))     (format "cljsjs/%1$s/development/%1$s.inc.js" (name project))
                   (re-pattern (format "^%s.production.min.js$" (name project))) (format "cljsjs/%1$s/production/%1$s.min.inc.js" (name project))
                   (re-pattern (format "^%s-deps.cljs" (name project))) "deps.cljs"})
      (sift :include #{#"^cljsjs" #"deps\.cljs"})
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

(deftask package []
  (comp
    (package-react)
    (package-dom)
    (package-dom-server)))

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
              (download :url (format "https://unpkg.com/%s@%s/umd/%s.development.js" (npm-project project) +lib-version+ (name project)))
              (download :url (format "https://unpkg.com/%s@%s/umd/%s.production.min.js" (npm-project project) +lib-version+ (name project)))))
      identity
      (keys checksums))
    (fn [handler]
      (fn [fileset]
        (println
          (clojure.string/replace
            (with-out-str
              (clojure.pprint/pprint (into {} (map (juxt identity (fn [project]
                                                                    {:dev (md5sum fileset (format "%s.development.js" (name project)))
                                                                     :min (md5sum fileset (format "%s.production.min.js" (name project)))}))
                                                   (keys checksums)))))
            #"cljsjs" "'cljsjs"))
        fileset))))
