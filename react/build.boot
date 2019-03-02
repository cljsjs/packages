(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "16.8.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react
       :version     +version+
       :description "A Javascript library for building user interfaces"
       :url         "http://facebook.github.io/react/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(defn download-react [project part]
  (comp
    (download :url (format "https://unpkg.com/%s@%s/umd/%s.development.js" project +lib-version+ part)
              :target (format "cljsjs/%1$s/development/%2$s.inc.js" project part))
    (download :url (format "https://unpkg.com/%s@%s/umd/%s.production.min.js" project +lib-version+ part)
              :target (format "cljsjs/%1$s/production/%2$s.min.inc.js" project part))))

(deftask package-react []
  (with-files (fn [x] (#{"react.ext.js"} (.getName (tmp-file x))))
    (comp
      (download-react "react" "react")
      (deps-cljs :provides ["react" "cljsjs.react"]
                 :requires []
                 :global-exports '{react React})
      (pom :project 'cljsjs/react
           :dependencies [])
      (show :fileset true)
      (jar))))

(deftask package-dom []
  (with-files (fn [x] (re-find #"react-dom.*\.ext\.js" (.getName (tmp-file x))))
    (comp
      (download-react "react-dom" "react-dom")
      (download-react "react-dom" "react-dom-server.browser")
      (download-react "react-dom" "react-dom-test-utils")
      (deps-cljs :foreign-libs [{:file #"react-dom\.inc\.js"
                                 :file-min #"react-dom\.min\.inc\.js"
                                 :provides ["react-dom" "cljsjs.react.dom"]
                                 :requires ["react"]
                                 :global-exports '{react-dom ReactDOM}}
                                {:file #"react-dom-server\.browser\.inc\.js"
                                 :file-min #"react-dom-server\.browser\.min\.inc\.js"
                                 :provides ["react-dom/server" "cljsjs.react.dom.server"]
                                 :requires ["react-dom"]
                                 :global-exports '{react-dom/server ReactDOMServer}}
                                {:file #"react-dom-test-utils\.inc\.js"
                                 :file-min #"react-dom-test-utils\.min\.inc\.js"
                                 :provides ["react-dom/test-utils" "cljsjs.react.dom.test-utils"]
                                 :requires ["react-dom"]
                                 :global-exports '{react-dom/test-utils ReactTestUtils}}]
                 :externs [#"react-dom.*\.ext\.js"])
      (pom :project 'cljsjs/react-dom
           :dependencies [['cljsjs/react +version+]])
      (show :fileset true)
      (jar))))

(deftask package-dom-server []
  (with-files (constantly nil)
    (comp
      (pom :project 'cljsjs/react-dom-server
           :description "React-dom-server package is now deprecated, the server file is included in react-dom package."
           :dependencies [['cljsjs/react-dom +version+]])
      (show :fileset true)
      (jar))))

(deftask package []
  (comp
    (package-react)
    (package-dom)
    (package-dom-server)
    (validate)))
