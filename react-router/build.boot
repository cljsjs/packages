(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]
                  [cljsjs/react       "0.13.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.13.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-router
       :version     +version+
       :description "A complete routing solution for React.js"
       :url         "https://github.com/rackt/react-router"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask download-react-router []
  (download :url      (format "https://github.com/rackt/react-router/archive/v%s.zip" +lib-version+)
            :checksum "e157777e2d854994aac43448b278b245"
            :unzip    true))

(deftask package []
  (comp
    (download-react-router)
    (sift :move {#"^react-.*/build/global/ReactRouter.js"
                 "cljsjs/react-router/development/react-router.inc.js"
                 #"^react-.*/build/global/ReactRouter.min.js"
                 "cljsjs/react-router/production/react-router.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-router"
               :requires ["cljsjs.react"])
    (pom)
    (jar)))
