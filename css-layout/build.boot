(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.0.1-0")
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
                             "ce81ef793a77fcc629f741d3323b01ef36b8628b.zip")
              :checksum "e131b71a5b9160c691e3557f2592c62c"
              :unzip    true)
   (sift      :move     {#"^css-layout-.*/src/Layout.js"
                         "cljsjs/css_layout/development/css-layout.inc.js"})
   (minify    :in       "cljsjs/css_layout/development/css-layout.inc.js"
              :out      "cljsjs/css_layout/production/css-layout.min.inc.js")
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.css-layout")))
