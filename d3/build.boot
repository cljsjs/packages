(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.9.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/d3
       :version     +version+
       :description "A JavaScript visualization library for HTML and SVG"
       :url         "http://d3js.org/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/d3/d3/releases/download/v" +lib-version+ "/d3.zip")
              :unzip true)
    (sift :move {#"^d3\.js"      "cljsjs/d3/development/d3.inc.js"
                 #"^d3\.min\.js" "cljsjs/d3/production/d3.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :provides ["d3" "cljsjs.d3"]
               :global-exports '{d3 d3}) 
    (pom)
    (jar)
	(validate-checksums)))
