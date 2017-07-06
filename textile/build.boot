(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/textile
       :version     +version+
       :description "A full-featured JavaScript Textile parser."
       :url         "https://github.com/borgar/textile-js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[clojure.java.io :as io])

(deftask package []
  (comp
    (download :url (format "https://cdnjs.cloudflare.com/ajax/libs/textile-js/%s/textile.min.js" +lib-version+)
              :checksum "7db6c0f13884c1bf743854ecba413cc2")
    (download :url (format "https://cdnjs.cloudflare.com/ajax/libs/textile-js/%s/textile.js" +lib-version+)
              :checksum "255188e022581421b31deaeb24677b17")
    (sift :move {#"^textile.js-\d.\d.\d/textile.js$"     "cljsjs/textile/development/textile.inc.js"
                 #"^textile.js-\d.\d.\d/textile.min.js$" "cljsjs/textile/production/textile.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.textile")
    (pom)
    (jar)))
