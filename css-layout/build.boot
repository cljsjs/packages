(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def package-version "1.0.0")
(def cljsjs-version "0")
(def +version+ (str package-version "-" cljsjs-version))
(bootlaces! (str +version+))

(task-options!
 pom  {:project     'cljsjs/css-layout
       :version     +version+
       :description "Reimplementation of CSS layout using pure JavaScript"
       :url         "https://github.com/facebook/css-layout"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
   (download  :url      (str "https://github.com/facebook/css-layout/archive/v1.0.0.zip")
              :checksum "6D4B4D24A36920052B4CCB52EE7DFBB0"
              :unzip    true)
   (sift      :move     {#"^css-layout-.*/src/Layout.js"
                         "cljsjs/css_layout/development/css-layout.inc.js"})
   (minify    :in       "cljsjs/css_layout/development/css-layout.inc.js"
              :out      "cljsjs/css_layout/production/css-layout.min.inc.js")
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.css-layout")))
