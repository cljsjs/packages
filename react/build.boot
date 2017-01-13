(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "15.4.0")
(def +version+ (str +lib-version+ "-0"))

(def checksums
  {'cljsjs/react
   {:dev "0F912566783AA1D49C9A3316EB47E086",
    :min "9A42408E46402432FA6A1C2771D35665"},
   'cljsjs/react-with-addons
   {:dev "808241E4C6C7E8577E67D70EFAE7A109",
    :min "44C28C5A95CC543CCA2816FA3B497AC6"},
   'cljsjs/react-dom
   {:dev "B4FF6AAB79B4C66DD549C566940FC06D",
    :min "A410393D94F024379CBEBE2B667CB3A8"},
   'cljsjs/react-dom-server
   {:dev "93F69DF7864ED9FF4909ED5F75844AC6",
    :min "208AB2445B8BAFD36369487EC9688EAB"}})

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
        (clojure.pprint/pprint (into {} (map (juxt identity (fn [project]
                                                              {:dev (md5sum fileset (format "%s.js" (name project)))
                                                               :min (md5sum fileset (format "%s.min.js" (name project)))}))
                                             (keys checksums))))
        fileset))))
