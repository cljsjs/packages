(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]
      	          [cljsjs/d3 "3.5.7-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.9")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/d3kit
       :version     +version+
       :description "Read and write OpenType fonts using JavaScript."
       :url         "https://github.com/twitter/d3kit"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
	
    (download :url (str "https://github.com/twitter/d3kit/archive/v" +lib-version+ ".zip")
              :checksum "f2aeb1938280b39506d0af506cc0515c"
              :unzip true)
    (sift :move {#"^d3kit-([\d\.]*)/dist/d3kit\.js"      "cljsjs/d3kit/development/d3kit.inc.js"
                 #"^d3kit-([\d\.]*)/dist/d3kit\.min\.js" "cljsjs/d3kit/production/d3kit.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.d3kit"
               :requires ["cljsjs.d3"])))
