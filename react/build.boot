(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.8.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "16.0.0")
(def +version+ (str +lib-version+ "-0"))

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

(defn package-part [{:keys [extern-name project dependencies requires provides global-exports file]}]
  (with-files (fn [x]
                (= extern-name (.getName (tmp-file x))))
    (comp
      (download :url (format "https://unpkg.com/%s@%s/umd/%s.development.js" (npm-project project) +lib-version+ (or file (name project)))
                :target (format "cljsjs/%1$s/development/%1$s.inc.js" (name project)))
      (download :url (format "https://unpkg.com/%s@%s/umd/%s.production.min.js" (npm-project project) +lib-version+ (or file (name project)))
                :target (format "cljsjs/%1$s/production/%1$s.min.inc.js" (name project)))
      (deps-cljs :provides provides
                 :requires requires
                 :global-exports global-exports)
      (pom :project project
           :dependencies (or dependencies []))
      (show :fileset true)
      (jar))))

(deftask package-react []
  (package-part
    {:extern-name "react.ext.js"
     :provides ["react" "cljsjs.react"]
     :global-exports '{react React}
     :project 'cljsjs/react}))

(deftask package-dom []
  (package-part
    {:extern-name "react-dom.ext.js"
     :provides ["react-dom" "cljsjs.react.dom"]
     :requires ["react"]
     :global-exports '{react-dom ReactDOM}
     :project 'cljsjs/react-dom
     :dependencies [['cljsjs/react +version+]]}))

(deftask package-dom-server []
  (package-part
    {:extern-name "react-dom-server.ext.js"
     :provides ["react-dom/server" "cljsjs.react.dom.server"]
     :requires ["react"]
     :global-exports '{react-dom/server ReactDOMServer}
     :project 'cljsjs/react-dom-server
     :file "react-dom-server.browser"
     :dependencies [['cljsjs/react +version+]]}))

(deftask package []
  (comp
    (package-react)
    (package-dom)
    (package-dom-server)
    (validate-checksums)))
