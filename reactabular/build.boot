(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]
		  [cljsjs/lodash "3.10.1-0"]
		  [cljsjs/react "0.13.3-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.7.0-0")

(task-options!
  pom  {:project     'cljsjs/reactabular
        :version     +version+
        :description "A React tabular component."
        :url         "http://bebraw.github.io/reactabular/"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url "https://raw.githubusercontent.com/bebraw/reactabular/v0.7.0/dist/reactabular.min.js"
             :checksum "e742794e7601268baa770063856c49f5")
   (download :url "https://raw.githubusercontent.com/bebraw/reactabular/v0.7.0/dist/reactabular.js"
             :checksum "711aa722262a045d2266110817213ddc")
   (sift :move {#"reactabular\.js" "cljsjs/reactabular/development/reactabular.inc.js"
                #"reactabular\.min\.js" "cljsjs/reactabular/production/reactabular.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.reactabular"
              :requires ["cljsjs.lodash" "cljsjs.react"])))
