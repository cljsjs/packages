(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6"  :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "7.0.1")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/chemdoodle
       :version     +version+
       :description "A JavaScript Chemostry Visualization Library"
       :url         "http://web.chemdoodle.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"GPL" "http://www.gnu.org/copyleft/gpl.html"}})

(deftask package []
  (comp
    (download :url "http://web.chemdoodle.com/downloads/ChemDoodleWeb-7.0.1.zip"
              :checksum "a080e2b2a701321b35ceaa5655d2c876"
              :unzip true)
    (sift :move {#"^ChemDoodleWeb-([\d\.]*)/src/ChemDoodleWeb-unpacked.js"
                 "cljsjs/chemdoodle/development/chemdoodle.inc.js"
                 
                 #"^ChemDoodleWeb-([\d\.]*)/install/ChemDoodleWeb.css" 
                 "cljsjs/chemdoodle/common/ChemDoodleWeb.css"
                 
                 #"^ChemDoodleWeb-([\d\.]*)/install/ChemDoodleWeb.js" 
                 "cljsjs/chemdoodle/production/chemdoodle.min.inc.js"
                 })
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.chemdoodle")))

