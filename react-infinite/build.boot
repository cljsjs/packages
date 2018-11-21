(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]
                 [cljsjs/react "16.3.0-1"]
                 [cljsjs/react-dom-server "16.3.0-1"]
                 [cljsjs/react-dom "16.3.0-1"]
                 [cljsjs/prop-types "15.6.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.13.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-infinite
       :version     +version+
       :description "A browser-ready efficient scrolling container based on UITableView."
       :url         "https://github.com/seatgeek/react-infinite"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/seatgeek/react-infinite/archive/" +lib-version+ ".zip")
             :unzip true)
   (sift :move {#"^react-infinite-(.*)/dist/react-infinite.js$"
                "cljsjs/react-infinite/development/react-infinite.inc.js"
                #"^react-infinite-(.*)/dist/react-infinite.min.js$"
                "cljsjs/react-infinite/production/react-infinite.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :foreign-libs [{:file #"react-infinite.inc.js"
                              :file-min #"react-infinite.min.inc.js"
                              :provides ["react-infinite" "cljsjs.react-infinite"]
                              :requires ["react" "react-dom" "prop-types"]}]
              :externs [#"react-infinite.ext.js"])
   (pom)
   (jar)
   (validate)))
