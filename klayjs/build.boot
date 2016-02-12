(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.3.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/klayjs
       :version     +version+
       :description "A layer-based layout algorithm, particularly suited for node-link diagrams with an inherent direction and ports."
       :url         "https://github.com/OpenKieler/klayjs"
       :scm         {:url "https://github.com/OpenKieler/klayjs"}
       :license     {"EPL" "http://www.eclipse.org/legal/epl-v10.html"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/OpenKieler/klayjs/archive/%s.zip" +lib-version+)
              :unzip true)
    (sift :move {#"^klayjs-.*/klay.js" "cljsjs/development/klay.inc.js"})
    (minify :in "cljsjs/development/klay.inc.js"
            :out "cljsjs/production/klay.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.klayjs")))
