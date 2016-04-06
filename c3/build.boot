(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]
                 [cljsjs/d3          "3.5.5-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.4.10")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/c3
       :version     +version+
       :description "A D3-based reusable chart library"
       :url         "http://c3js.org/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url      (str "https://github.com/masayuki0812/c3/archive/" +lib-version+ ".zip")
             :checksum "86E26485D03248E7D989B4FBD8A63ECD"
             :unzip    true)
   (sift :move {#"^c3-([\d\.]*)/c3\.js"      "cljsjs/c3/development/c3.inc.js"
                #"^c3-([\d\.]*)/c3\.min\.js" "cljsjs/c3/production/c3.min.inc.js"
                #"^c3-([\d\.]*)/c3\.css"      "cljsjs/c3/common/c3.css"
                #"^c3-([\d\.]*)/c3\.min\.css" "cljsjs/c3/common/c3.min.css"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.c3"
              :requires ["cljsjs.d3"])
   (pom)
   (jar)))
