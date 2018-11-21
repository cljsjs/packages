(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/d3 "4.3.0-5"]
                 [cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.7.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/d3-tip
       :version     +version+
       :description "Tooltip Support for D3"
       :url         "https://github.com/Caged/d3-tip/"
       :scm         {:url "https://github.com/Caged/d3-tip/"}
       :license     {"MIT" "https://raw.githubusercontent.com/Caged/d3-tip/master/LICENSE"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/Caged/d3-tip/archive/v" +lib-version+ ".zip")
             :checksum "23B59FD16A8AC2CFDC7EDACEAD5A005C"
             :unzip true)
   (sift :move {#"^d3-tip-.*/index.js" "cljsjs/d3-tip/development/d3-tip.inc.js"})
   (minify :in "cljsjs/d3-tip/development/d3-tip.inc.js"
           :out "cljsjs/d3-tip/production/d3-tip.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.d3-tip"
              :requires ["cljsjs.d3"])
   (pom)
   (jar)))
