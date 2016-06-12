(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[boot.task.built-in :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.12.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/amplitude
       :version     +version+
       :description "Javascript SDK for Amplitude"
       :url         "https://github.com/amplitude/Amplitude-Javascript"
       :scm         {:url "https://github.com/amplitude/Amplitude-Javascript"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url "https://d24n15hnbwhuhn.cloudfront.net/libs/amplitude-2.12.1.js")
    (download :url "https://d24n15hnbwhuhn.cloudfront.net/libs/amplitude-2.12.1-min.js")
    (sift :move {#"^amplitude-([\d\.]*)\.js$" "cljsjs/amplitude/development/amplitude.inc.js"
                 #"^amplitude-([\d\.]*)\-min.js$" "cljsjs/amplitude/production/amplitude.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.amplitude")
    (pom)
    (jar)))
