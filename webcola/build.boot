(set-env!
   :resource-paths #{"resources"}
   :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

 (def +lib-version+ "3.4.0")
 (def +version+ (str +lib-version+ "-0"))

 (require '[cljsjs.boot-cljsjs.packaging :refer :all])

 (task-options!
   pom {:project     'cljsjs/webcola
        :version     +version+
        :description "JavaScript constraint based layout for high-quality graph visualization"
        :url         "https://ialab.it.monash.edu/webcola"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})
 
 (deftask package []
   (comp
     (download :url (format "https://unpkg.com/webcola@%s/WebCola/cola.js" +lib-version+)
             :target "cljsjs/webcola/development/cola.inc.js")
	 (download :url (format "https://unpkg.com/webcola@%s/WebCola/cola.min.js" +lib-version+)
             :target "cljsjs/webcola/production/cola.min.inc.js")
	 (download :url (format "https://unpkg.com/webcola@%s/WebCola/style.css" +lib-version+)
             :target "cljsjs/webcola/common/style.inc.css")
     (deps-cljs :name "cljsjs.webcola")
     (pom)
     (jar)))