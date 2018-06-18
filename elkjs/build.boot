(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.8.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.3.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/elkjs
       :version     +version+
       :description "The Eclipse Layout Kernel (ELK) implements an infrastructure to connect diagram editors or viewers to automatic layout algorithms. This library takes the layout-relevant part of ELK and makes it available to the JavaScript world."
       :url         "https://github.com/OpenKieler/elkjs"
       :scm         {:url "https://github.com/OpenKieler/elkjs"}
       :license     {"EPL" "http://www.eclipse.org/legal/epl-v10.html"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/elkjs@%s/lib/elk.bundled.js" +lib-version+))
    (sift :move {#"elk.bundled.js" "cljsjs/development/elk.inc.js"})
    (minify :in "cljsjs/development/elk.inc.js"
            :out "cljsjs/production/elk.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.elkjs")
    (pom)
    (jar)))
