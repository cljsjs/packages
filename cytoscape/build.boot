(set-env!
   :resource-paths #{"resources"}
   :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

 (def +lib-version+ "3.23.0")
 (def +version+ (str +lib-version+ "-0"))

 (require '[cljsjs.boot-cljsjs.packaging :refer :all])

 (task-options!
   pom {:project     'cljsjs/cytoscape
        :version     +version+
        :description "Graph theory / network library for analysis and visualisation"
        :url         "http://js.cytoscape.org/"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})
 (deftask package []
   (comp
     (download :url (format "https://cdnjs.cloudflare.com/ajax/libs/cytoscape/%s/cytoscape.esm.js" +lib-version+))
     (download :url (format "https://cdnjs.cloudflare.com/ajax/libs/cytoscape/%s/cytoscape.esm.min.js" +lib-version+))
     (sift :move {#"cytoscape.esm.js" "cljsjs/production/cytoscape.inc.js"
                  #"cytoscape.esm.min.js" "cljsjs/production/cytoscape.min.inc.js"})
     (sift :include #{#"^cljsjs"})
     #_(show :fileset true)
     (deps-cljs :name "cljsjs.cytoscape")
     (pom)
     (jar)
     (validate-checksums)))

