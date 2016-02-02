(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]
                	[cljsjs/d3 "3.5.7-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.1.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/labella
       :version     +version+
       :description "Read and write OpenType fonts using JavaScript."
       :url         "http://twitter.github.io/labella.js/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache 2.0" "https://opensource.org/licenses/Apache-2.0"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/twitter/labella.js/archive/v" +lib-version+ ".zip")
              :checksum "9be4a8e5886cb87ed7d22c370d75f599"
              :unzip true)
    (sift :move {#"^labella.js-([\d\.]*)/dist/labella\.js"      "cljsjs/labella/development/labella.inc.js"
                 #"^labella.js-([\d\.]*)/dist/labella\.min\.js" "cljsjs/labella/production/labella.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.labella"
			         :requires ["cljsjs.d3"])))
