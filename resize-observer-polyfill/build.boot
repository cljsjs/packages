(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.4.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/resize-observer-polyfill
       :version     +version+
       :description "A polyfill for the Resize Observer API."
       :url         "https://github.com/que-etc/resize-observer-polyfill"
       :scm         {:url "https://github.com/que-etc/resize-observer-polyfill"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str
                    "https://raw.githubusercontent.com/que-etc/resize-observer-polyfill/"
                    +lib-version+
                    "/dist/ResizeObserver.js")
              :checksum "BEC109D950AE3FEE706CF229CBA61256")
    (minify :in "ResizeObserver.js"
            :out "ResizeObserver.min.js")
    (sift :move {#"^ResizeObserver.js"     "cljsjs/resize-observer-polyfill/development/resize-observer-polyfill.inc.js"
                 #"^ResizeObserver.min.js" "cljsjs/resize-observer-polyfill/production/resize-observer-polyfill.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.resize-observer-polyfill")
    (pom)
    (jar)))
