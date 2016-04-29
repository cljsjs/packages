(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]
                  [cljsjs/react "0.14.3-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.6.2")
(def +version+ (str +lib-version+ "-0"))

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
    (download :url "https://raw.githubusercontent.com/sanniassin/react-input-mask/0.6.2/build/InputElement.js"
              :checksum "75D0299C71420641A8503F3ED4383835")

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
