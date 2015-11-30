(def +version+ "0.6.2")

(set-env!
  :resource-paths #{"resources"}
  :dependencies [['adzerk/bootlaces   "0.1.9" :scope "test"]
                 ['cljsjs/boot-cljsjs "0.5.0" :scope "test"]
                 ['cljsjs/react       "0.14.0-1" :scope "provided"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/react-input-autosize
       :version     +version+
       :description "Auto-resizing input field for React"
       :url         "https://github.com/JedWatson/react-input-autosize"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package  []
  (task-options! push {:ensure-branch nil :tag false})
  (comp
    (download :url (str "https://github.com/JedWatson/react-input-autosize/archive/v" +version+ ".zip")
              :checksum "9b75515657de750d97a986f8c5bab0b7"
              :unzip true)
    (sift :move {#"^react-input-autosize-(.*)/dist/react-input-autosize\.js$"
                 "cljsjs/react-input-autosize/development/react-input-autosize.inc.js"

                 #"^react-input-autosize-(.*)/dist/react-input-autosize\.min\.js$"
                 "cljsjs/react-input-autosize/production/react-input-autosize.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-input-autosize" :requires ["cljsjs.react"])))
