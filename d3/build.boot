(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.5.7")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/d3
       :version     +version+
       :description "A JavaScript visualization library for HTML and SVG"
       :url         "http://d3js.org/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/mbostock/d3/archive/v" +lib-version+ ".zip")
              :checksum "8FBD9872D28CCFE1F266A6EE4B5D4205"
              :unzip true)
    (sift :move {#"^d3-([\d\.]*)/d3\.js"      "cljsjs/d3/development/d3.inc.js"
                 #"^d3-([\d\.]*)/d3\.min\.js" "cljsjs/d3/production/d3.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.d3")))
