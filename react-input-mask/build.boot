(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]
                  [cljsjs/react "0.14.3-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.5.10")
(def +version+ (str +lib-version+ "-3"))

(task-options!
 pom  {:project     'cljsjs/react-input-mask
       :version     +version+
       :description "Yet another react component for input masking"
       :url         "https://github.com/sanniassin/react-input-mask"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask package []
  (comp
    (download :url "https://raw.githubusercontent.com/sanniassin/react-input-mask/05c101e4937d54966f673113a1432afb53fb9541/build/InputElement.js"
              :checksum "43D89151C1CF4F37100CFA50DCA54B42")

    (replace-content :in "InputElement.js" :out "InputElement.js"
      :match #"var React = require.*;"
      :value "")
    (replace-content :in "InputElement.js" :out "InputElement.js"
      :match #"module.exports = .*;"
      :value "")

    (sift :move {#"^InputElement.js$" "cljsjs/react-input-mask/development/react-input-mask.inc.js"})

    (minify :in "cljsjs/react-input-mask/development/react-input-mask.inc.js"
            :out "cljsjs/react-input-mask/production/react-input-mask.min.inc.js")

    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-input-mask"
               :requires ["cljsjs.react"])
    (pom)
    (jar)))
