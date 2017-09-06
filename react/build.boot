(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.7.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "16.0.0-beta.5")
(def +version+ (str +lib-version+ "-1"))

(def checksums
  {'cljsjs/react
   {:dev "DD64BC7E1110980E9418DBB3DBC68EC1",
    :min "D998457DD5E84656C5875C3200267445"},
   'cljsjs/react-dom
   {:dev "3C0AFF9D9436BA38A2602D56042F9104",
    :min "E63E656CB262A5FC9D41331686A816E1"},
   'cljsjs/react-dom-server
   {:dev "976EC28B915E9B1D324F211E6732B1EB",
    :min "F632B2BB8D21E6754FBB1871B2C2E352"}})

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

(defn package-part [{:keys [extern-name namespace project dependencies requires file]}]
  (with-files (fn [x]
                (or (= extern-name (.getName (tmp-file x)))
                    (= (str (name project) "-deps.cljs") (.getName (tmp-file x)))))
    (comp
      (download :url (format "https://unpkg.com/%s@%s/umd/%s.development.js" (npm-project project) +lib-version+ (or file (name project)))
                :checksum (:dev (get checksums project)))
      (download :url (format "https://unpkg.com/%s@%s/umd/%s.production.min.js" (npm-project project) +lib-version+ (or file (name project)))
                :checksum (:min (get checksums project)))
      (sift :move {(re-pattern (format "^%s(.browser)?.development.js$" (name project)))     (format "cljsjs/%1$s/development/%1$s.inc.js" (name project))
                   (re-pattern (format "^%s(.browser)?.production.min.js$" (name project))) (format "cljsjs/%1$s/production/%1$s.min.inc.js" (name project))
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
     :file "react-dom-server.browser"
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
        (let [n (case project
                  'cljsjs/react-dom-server "react-dom-server.browser"
                  (name project))]
          (comp handler
                (download :url (format "https://unpkg.com/%s@%s/umd/%s.development.js" (npm-project project) +lib-version+ n))
                (download :url (format "https://unpkg.com/%s@%s/umd/%s.production.min.js" (npm-project project) +lib-version+ n)))))
      identity
      (keys checksums))
    (fn [handler]
      (fn [fileset]
        (println
          (clojure.string/replace
            (with-out-str
              (clojure.pprint/pprint (into {} (map (juxt identity (fn [project]
                                                                    (let [n (case project
                                                                              'cljsjs/react-dom-server "react-dom-server.browser"
                                                                              (name project))]
                                                                      {:dev (md5sum fileset (format "%s.development.js" n))
                                                                       :min (md5sum fileset (format "%s.production.min.js" n))})))
                                                   (keys checksums)))))
            #"cljsjs" "'cljsjs"))
        fileset))))
