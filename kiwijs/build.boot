(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/kiwijs
       :version     +version+
       :description "A layer-based layout algorithm, particularly suited for node-link diagrams with an inherent direction and ports."
       :url         "https://github.com/OpenKieler/kiwijs"
       :scm         {:url "https://github.com/OpenKieler/kiwijs"}
       :license     {"EPL" "http://www.eclipse.org/legal/epl-v10.html"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/kiwi.js@%s/lib/kiwi.js" +lib-version+))
    (sift :move {#"kiwi.js" "cljsjs/development/kiwi.inc.js"})
    (minify :in "cljsjs/development/kiwi.inc.js"
            :out "cljsjs/production/kiwi.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.kiwijs")
    (validate)
    (pom)
    (jar)))
