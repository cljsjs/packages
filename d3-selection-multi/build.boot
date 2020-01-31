(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]
                  [cljsjs/d3 "4.3.0-4"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.1")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/d3-selection-multi
       :version     +version+
       :description "Multi-value syntax for D3 selections and transitions"
       :url         "http://d3js.org/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/d3/d3-selection-multi/releases/download/v" +lib-version+ "/d3-selection-multi.zip")
              :checksum "1521E418857CC0EB43C8A99CA38672F0"
              :unzip true)
    (sift :move {#"^d3-selection-multi\.js"      "cljsjs/d3/development/d3-selection-multi.inc.js"
                 #"^d3-selection-multi\.min\.js" "cljsjs/d3/production/d3-selection-multi.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.d3-selection-multi"
               :requires ["cljsjs.d3"])
    (pom)
    (jar)))
