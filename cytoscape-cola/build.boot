(set-env!
   :resource-paths #{"resources"}
   :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
				   [cljsjs/cytoscape "3.1.4-0"]
				   [cljsjs/webcola "3.4.0-0"]])

 (def +lib-version+ "2.3.1")
 (def +version+ (str +lib-version+ "-0"))

 (require '[cljsjs.boot-cljsjs.packaging :refer :all])

 (task-options!
   pom {:project     'cljsjs/cytoscape-cola
        :version     +version+
        :description "The Cola.js physics simulation layout for Cytoscape.js "
        :url         "https://github.com/cytoscape/cytoscape.js-cola"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})
 
 (deftask package []
   (comp
     (download :url (format "https://unpkg.com/cytoscape-cola@%s/cytoscape-cola.js" +lib-version+)
               :target "cljsjs/cytoscape-cola/development/cytoscape-cola.inc.js")
			   
	 (download :url (format "https://unpkg.com/cytoscape-cola@%s/cytoscape-cola.js" +lib-version+)
               :target "cljsjs/cytoscape-cola/production/cytoscape-cola.min.inc.js")

     (sift :include #{#"^cljsjs"})			   
     (deps-cljs :name "cljsjs.cytoscape-cola"
	            :requires ["cljsjs.cytoscape"
				           "cljsjs.webcola"])
     (pom)
     (jar)))