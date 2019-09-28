(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.4.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/d3-format
       :version     +version+
       :description "Format numbers for human consumption."
       :url         "https://d3js.org/d3-format/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/d3/d3-format/releases/download/v" +lib-version+ "/d3-format.zip")
             :unzip true)
   (sift :move {#"^d3-format\.js"      "cljsjs/d3-format/development/d3-format.inc.js"
                #"^d3-format\.min\.js" "cljsjs/d3-format/production/d3-format.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.d3-format")
   (pom)
   (jar)
   (validate-checksums)))
