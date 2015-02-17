(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.0.1-2")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/css-layout
       :version     +version+
       :description "Reimplementation of CSS layout using pure JavaScript"
       :url         "https://github.com/facebook/css-layout"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
   (download  :url      (str "https://github.com/facebook/css-layout/archive/"
                             "b99ce3736fae487873f6bdd8bde4ff34ed2747fc.zip")
              :checksum "7dd61f07c0c267327069e8b0749d5b2d"
              :unzip    true)
   (sift      :move     {#"^css-layout-.*/src/Layout.js"
                         "cljsjs/css_layout/development/css-layout.inc.js"})
   (minify    :in       "cljsjs/css_layout/development/css-layout.inc.js"
              :out      "cljsjs/css_layout/production/css-layout.min.inc.js")
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.css-layout")))
