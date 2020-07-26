(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "10.3.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-jss
       :version     +version+
       :description "A lib for generating Style Sheets with JavaScript."
       :url         "https://github.com/cssinjs/jss"
       :scm         {:url "https://github.com/cssinjs/jss"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(defn download-react-jss []
  (comp
   (download :url (format "https://raw.githubusercontent.com/FieryCod/cljs-react-jss/master/resources/cljsjs/react-jss.js")
             :target (format "cljsjs/react-jss/development/react-jss.inc.js"))
   (download :url (format "https://raw.githubusercontent.com/FieryCod/cljs-react-jss/master/resources/cljsjs/react-jss.min.js")
             :target (format "cljsjs/react-jss/production/react-jss.min.inc.js"))))

(deftask package-react-jss []
  (with-files (fn [x] (#{"react-jss.ext.js"} (.getName (tmp-file x))))
    (comp
     (download-react-jss)
     (deps-cljs :provides ["react-jss" "cljsjs.react-jss"]
                :requires ["react"]
                :global-exports '{react-jss ReactJSS})
     (pom :project 'cljsjs/react-jss
          :dependencies [])
     (show :fileset true)
     (jar))))

(deftask package []
  (comp
   (package-react-jss)
   (validate)))
