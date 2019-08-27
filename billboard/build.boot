(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]
                 [cljsjs/d3          "4.3.0-5"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/billboard
       :version     +version+
       :description "A re-usable easy interface JavaScript chart library, based on D3 v4+"
       :url         "https://naver.github.io/billboard.js/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url      (str "https://github.com/naver/billboard.js/archive/" +lib-version+ ".zip")
             :checksum "a73796b55c5274a3370089fb2f9216d3"
             :unzip    true)
   (sift :move {#"^billboard.js-([\d\.]*)/dist/billboard\.js"      "cljsjs/billboard/development/billboard.inc.js"
                #"^billboard.js-([\d\.]*)/dist/billboard\.min\.js" "cljsjs/billboard/production/billboard.min.inc.js"
                #"^billboard.js-([\d\.]*)/dist/billboard\.css"      "cljsjs/billboard/common/billboard.css"
                #"^billboard.js-([\d\.]*)/dist/billboard\.min\.css" "cljsjs/billboard/common/billboard.min.css"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.billboard"
              :requires ["cljsjs.d3"])
   (pom)
   (jar)))
