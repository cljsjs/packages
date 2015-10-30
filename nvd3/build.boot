(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0"  :scope "test"]
                  [cljsjs/d3          "3.5.5-3"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "1.7.1-0")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/nvd3
       :version     +version+
       :description "A reusable chart library for d3.js"
       :url         "http://nvd3-community.github.io/nvd3/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
    (download :url "https://github.com/nvd3-community/nvd3/zipball/master"
              :unzip true)
    (sift :move {#"^nvd3-community-nvd3-([\w\.]*)/build/nv\.d3\.js"      "cljsjs/nvd3/development/nvd3.inc.js"
                 #"^nvd3-community-nvd3-([\w\.]*)/build/nv\.d3\.min\.js" "cljsjs/nvd3/production/nvd3.min.inc.js"
                 #"^nvd3-community-nvd3-([\w\.]*)/build/nv\.d3\.css"      "cljsjs/nvd3/development/nvd3.inc.css"
                 #"^nvd3-community-nvd3-([\w\.]*)/build/nv\.d3\.min\.css" "cljsjs/nvd3/production/nvd3.min.inc.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.nvd3"
               :requires ["cljsjs.d3"])))