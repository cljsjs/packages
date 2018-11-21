(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]
                  [cljsjs/react       "15.6.1-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.6.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-router
       :version     +version+
       :description "Declarative routing for React"
       :url         "https://github.com/ReactTraining/react-router"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url      (format "https://unpkg.com/react-router@%s/umd/ReactRouter.js" +lib-version+)
              :checksum "5eac948ffc02da2797ff249df2e35db0")
    (download :url      (format "https://unpkg.com/react-router@%s/umd/ReactRouter.min.js" +lib-version+)
              :checksum "8735bbad04ab7967bab88b9bbcbb2dd8")
    (sift :move {#"ReactRouter.js"
                 "cljsjs/react-router/development/react-router.inc.js"
                 #"ReactRouter.min.js"
                 "cljsjs/react-router/production/react-router.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-router"
               :requires ["cljsjs.react"])
    (pom)
    (jar)))
