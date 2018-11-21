(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]
                 ])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.2.5")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/material-colors
      :version     +version+
      :description "Material design colors defined in a Javascript object"
      :url         "http://shuheikagawa.com/material-colors/"
      :scm         {:url "https://github.com/shuhei/material-colors"}
      :license     {"Apache v2" "http://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (comp
   (download  :url      (format "https://github.com/shuhei/material-colors/archive/v%s.zip" +lib-version+)
              :checksum "be187da768ac85f9e18d3bc6275365b9"
              :unzip    true)
   (sift      :move     {#"^material-colors(.*)/dist/colors.js$"
                         "cljsjs/material-colors/development/material-colors.inc.js"})
   (minify    :in "cljsjs/material-colors/development/material-colors.inc.js"
              :out "cljsjs/material-colors/production/material-colors.min.inc.js")
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.material-colors")
   (pom)
   (jar)))
