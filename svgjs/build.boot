(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.2.5")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/svgjs
       :version     +version+
       :description "A lightweight library for manipulating and animating SVG"
       :url         "http://svgjs.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(defn github [file]
  (str "https://raw.githubusercontent.com/wout/svg.js/"
       +lib-version+ "/dist/" file))

(deftask package []
  (comp
   (download :url (github "svg.js")
             :checksum "694AA86646313E9E0F33930A9E9DFB04")
   (download :url (github "svg.min.js")
             :checksum "4AB31486CB67FEBD810EACB6C39A273F")
    (sift :move {#"svg.js" "cljsjs/svgjs/development/svg.inc.js"
                 #"svg.min.js" "cljsjs/svgjs/production/svg.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.svgjs")))
