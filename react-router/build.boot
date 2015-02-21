(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.12.0-0")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/react-router
       :version     +version+
       :description "React-Routers packaged up with Google Closure externs"
       :url         "https://github.com/rackt/react-router"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask download-react []
  (download :url "https://github.com/rackt/react-router/archive/v0.12.0.zip"
              :checksum "88780b2cb979715febaa762320943def"
              :unzip true))

(deftask package []
  (comp
    (download-react)
    (sift :move {#"^react-.*/dist/react-router.js" "cljsjs/development/react-router.inc.js"
                 #"^react-.*/dist/react-router.min.js" "cljsjs/production/react-router.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-router")))
