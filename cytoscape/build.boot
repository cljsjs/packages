(set-env!
   :resource-paths #{"resources"}
   :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

 (def +lib-version+ "3.1.4")
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
     (download :url (format "https://cdnjs.cloudflare.com/ajax/libs/cytoscape/%s/cytoscape.js" +lib-version+)
       :checksum "E9EB1C298A2473B225B7794233B8FB4E")
     (download :url (format "https://cdnjs.cloudflare.com/ajax/libs/cytoscape/%s/cytoscape.min.js" +lib-version+)
       :checksum "903E51FD46072FD03A09B95C874D64FB")
     (sift :move {#"cytoscape.js" "cljsjs/development/cytoscape.inc.js"
                  #"cytoscape.min.js" "cljsjs/production/cytoscape.min.inc.js"})
     (sift :include #{#"^cljsjs"})
     (deps-cljs :name "cljsjs.cytoscape")
     (pom)
     (jar)))

