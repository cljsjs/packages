(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.4.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/diffdom
      :version     +version+
      :description "diffdom - A JavaScript diffing algorithm for DOM elements"
      :url         "https://github.com/fiduswriter/diffDOM"
      :license     {"GNUv3" "https://github.com/fiduswriter/diffDOM/blob/gh-pages/LICENSE.txt"}
      :scm         {:url "https://github.com/cljsjs/packages"}})

(defn cdn-ver [file]
  (str "https://raw.githubusercontent.com/fiduswriter/diffDOM/v" +lib-version+ "/" file))

(deftask package []
  (comp
    (download :url (cdn-ver "diffDOM.js"))
    (sift :move
          {#"diffDOM.js" "cljsjs/diffdom/development/diffdom.inc.js"})
    (minify :in "cljsjs/diffdom/development/diffdom.inc.js"
            :out "cljsjs/diffdom/production/diffdom.min.inc.js.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.diffdom")
    (pom)
    (jar)
    (validate)))
