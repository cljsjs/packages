(def +lib-release+ "0")
(def +lib-version+ (str "0." +lib-release+ ".0"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.task.built-in :refer :all])

(task-options!
 pom  {:project     'cljsjs/maptastic
       :version     +lib-version+
       :description "Javascript/CSS projection mapping utility."
       :url         "https://github.com/glowbox/maptasticjs"
       :license     {"Copyright (C) 2015 by Glowbox LLC"
                     "https://raw.githubusercontent.com/glowbox/maptasticjs/master/license.txt"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url
             "https://raw.githubusercontent.com/glowbox/maptasticjs/master/build/maptastic.min.js"
             :checksum
             "8600104d8e1006e83f4a4e602a409c33")

   (download :url
             "https://raw.githubusercontent.com/glowbox/maptasticjs/master/build/maptastic.js"
             :checksum
             "826710c954ef1fbd989d040dace76e61")

    (sift :move {#"^maptastic.min.js" "cljsjs/maptastic/production/maptastic.min.inc.js"})
    (sift :move {#"^maptastic.js" "cljsjs/maptastic/development/maptastic.inc.js"})

  	(sift :include #{#"^cljsjs"})
  	(deps-cljs :name "maptastic")
  	(show)
  	(pom)
    (jar)))
