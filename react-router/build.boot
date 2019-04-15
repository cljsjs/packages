(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]
                  [cljsjs/react       "16.8.3-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.0.0")
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
    (download :url      (format "https://unpkg.com/react-router@%s/umd/react-router.js" +lib-version+))
    (download :url      (format "https://unpkg.com/react-router@%s/umd/react-router.min.js" +lib-version+))
    (sift :move {#"react-router.js"
                 "cljsjs/react-router/development/react-router.inc.js"
                 #"react-router.min.js"
                 "cljsjs/react-router/production/react-router.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-router"
               :requires ["cljsjs.react"])
    (pom)
    (jar)
    (validate)))
