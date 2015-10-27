(def +version+ "0.8.2-0")

(set-env!
  :resource-paths #{"resources"}
  :dependencies [['adzerk/bootlaces   "0.1.9" :scope "test"]
                 ['cljsjs/boot-cljsjs "0.5.0" :scope "test"]
                 ['cljsjs/react       "0.14.0-1" :scope "provided"]
                 ['cljsjs/react-dom   "0.14.0-1" :scope "provided"]
                 ['cljsjs/classnames  "2.1.3-0"]
                 ['cljsjs/react-input-autosize "0.6.2"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/react-select
       :version     +version+
       :description "A Select control built with and for React JS"
       :url         "http://jedwatson.github.io/react-select"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package  []
  (task-options! push {:ensure-branch nil :tag false})
  (comp
    (download :url (str "https://github.com/kibu-australia/react-select/archive/v" +version+ ".zip")
              :checksum "9f46d27cb4f5c750fe18f061cff13658"
              :unzip true)
    (sift :move {#"^react-select-(.*)/dist\/react-select\.js$"
                 "cljsjs/react-select/development/react-select.inc.js"

                 #"^react-select-(.*)/dist\/default\.css$"
                 "cljsjs/react-select/common/react-select.inc.css"

                 #"^react-select-(.*)/dist\/react-select\.min\.js$"
                 "cljsjs/react-select/production/react-select.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-select" :requires ["cljsjs.react" "cljsjs.react.dom" "cljsjs.classnames" "cljsjs.react-input-autosize"])))
