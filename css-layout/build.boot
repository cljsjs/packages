(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/css-layout
       :version     +version+
       :description "Reimplementation of CSS layout using pure JavaScript"
       :url         "https://github.com/facebook/css-layout"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
   (download  :url      (str "https://github.com/facebook/css-layout/archive/v" +lib-version+ ".zip")
              :checksum "6D4B4D24A36920052B4CCB52EE7DFBB0"
              :unzip    true)
   (sift      :move     {#"^css-layout-.*/src/Layout.js"
                         "cljsjs/css_layout/development/css-layout.inc.js"})
   (minify    :in       "cljsjs/css_layout/development/css-layout.inc.js"
              :out      "cljsjs/css_layout/production/css-layout.min.inc.js")
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.css-layout")
   (pom)
   (jar)))
