(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]
                  [degree9/boot-npm "1.4.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])
(require '[degree9.boot-npm :as npm])

(def +lib-version+ "3.1.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/proton-js
       :version     +version+
       :description "a lightweight javascript particle engine"
       :url         "https://projects.jpeer.at/proton/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (npm/npm :install {:proton-js +lib-version+})
   (sift :move {#"node_modules/proton-js/build/proton\.js$" "cljsjs/proton/development/pproton.inc.js"
                #"node_modules/proton-js/build/proton\.min\.js$" "cljsjs/proton/production/proton.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.proton-js")
    (pom)
    (jar)))
