(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[boot.task-helpers]
         '[cljsjs.boot-cljsjs.packaging :refer :all])


(def +lib-version+ "1.3.0")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  push {:ensure-clean false}
  pom  {:project     'cljsjs/rangy-core
        :version     +version+
        :description "A cross-browser JavaScript range and selection library"
        :url         "https://github.com/timdown/rangy"
        :license     {"MIT" "https://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url (format
                     "https://raw.githubusercontent.com/timdown/rangy/%s/lib/rangy-core.js"
                     +lib-version+)
              :checksum "cb6799dfcd008465f26237be80374afd")
    (sift :move {#"^rangy-core\.js"
                 "cljsjs/rangy/development/rangy-core.inc.js"})
    (minify :in "cljsjs/rangy/development/rangy-core.inc.js"
            :out "cljsjs/rangy/production/rangy-core.min.inc.js")

    (sift :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.rangy-core")
    (pom)
    (jar)))
