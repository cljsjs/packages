(def +lib-version+ "0.0.0")
(def +version+ (str +lib-version+ "-0"))
(def +sha-version+ "641e4708707780a5cffba6902ab09445ab431374")

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/maptastic
       :version     +version+
       :description "Javascript/CSS projection mapping utility."
       :url         "https://github.com/glowbox/maptasticjs"
       :license     {"Copyright (C) 2015 by Glowbox LLC"
                     "https://raw.githubusercontent.com/glowbox/maptasticjs/master/license.txt"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url (format "https://raw.githubusercontent.com/glowbox/maptasticjs/%s/build/maptastic.min.js" +sha-version+)
              :checksum "8600104d8e1006e83f4a4e602a409c33")

    (download :url (format "https://raw.githubusercontent.com/glowbox/maptasticjs/%s/build/maptastic.js" +sha-version+)
              :checksum "826710c954ef1fbd989d040dace76e61")

    (sift :move {#"^maptastic.min.js" "cljsjs/maptastic/production/maptastic.min.inc.js"})
    (sift :move {#"^maptastic.js" "cljsjs/maptastic/development/maptastic.inc.js"})

    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.maptastic")
    (pom)
    (jar)))
