(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]
                  [cljsjs/react "16.3.0-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.6.4")
(def +version+ (str +lib-version+ "-1"))
(def +lib-folder+ (str "react-pose" +lib-version+))

(task-options!
 pom  {:project     'cljsjs/react-pose
       :version     +version+
       :description "Popmotion React Pose Library for Clojurescript"
       :url         "https://github.com/Popmotion/popmotion"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url      (str "https://unpkg.com/react-pose@" +lib-version+ "/dist/react-pose.js")
              :target "cljsjs/react-pose/react-pose.inc.js"
              :checksum "954C02AD344A9A696C20631D52784931")
    (deps-cljs :provides ["react-pose" "cljsjs.react-pose"]
               :requires ["react"])
    (sift :include #{#"^cljsjs" #"^deps.cljs"})
    (pom)
    (jar)))
