(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/colorbrewer
       :version     +version+
       :description "A set of colors based on Cynthia Brewer's Colorbrewer"
       :url         "http://colorbrewer2.org/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
   (download :url "https://raw.githubusercontent.com/mbostock/d3/5b981a18db32938206b3579248c47205ecc94123/lib/colorbrewer/colorbrewer.js"
             :checksum "decbf788d30fa9cc409f8ce40c909d48")
   (sift :move {#"colorbrewer.js" "cljsjs/colorbrewer/development/colorbrewer.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.colorbrewer")
   (pom)
   (jar)))
