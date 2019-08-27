(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]
                 [cljsjs/d3 "4.3.0-5"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.1")
(def +version+ (str +lib-version+ "-2"))

(task-options!
 pom  {:project     'cljsjs/d3-scale-chromatic
       :version     +version+
       :description "D3 Sequential, diverging and categorical color schemes from ColorBrewer."
       :url         "https://d3js.org/d3-scale-chromatic/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/d3/d3-scale-chromatic/releases/download/v" +lib-version+ "/d3-scale-chromatic.zip")
             :checksum "42A9270FAD3FF27BAE2EFFD02BF6E336"
             :unzip true)
   (sift :move {#"^d3-scale-chromatic\.js"      "cljsjs/d3-scale-chromatic/development/d3-scale-chromatic.inc.js"
                #"^d3-scale-chromatic\.min\.js" "cljsjs/d3-scale-chromatic/production/d3-scale-chromatic.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.d3-scale-chromatic"
              :requires ["cljsjs.d3"])
   (pom)
   (jar)))
