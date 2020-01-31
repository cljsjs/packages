(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.9")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/reactabular
        :version     +version+
        :description "A React tabular component."
        :url         "http://bebraw.github.io/reactabular/"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (format "https://raw.githubusercontent.com/bebraw/reactabular/v%s/dist/reactabular.min.js" +lib-version+)
             :checksum "25f90f52196a753a2358fa74013a000d")
   (download :url (format "https://raw.githubusercontent.com/bebraw/reactabular/v%s/dist/reactabular.js" +lib-version+)
             :checksum "c97541ce7073ed82dc6fc8efc43f2d76")
   (sift :move {#"reactabular\.js" "cljsjs/reactabular/development/reactabular.inc.js"
                #"reactabular\.min\.js" "cljsjs/reactabular/production/reactabular.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.reactabular")
   (pom)
   (jar)))
