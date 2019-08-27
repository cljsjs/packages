(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]
                  [cljsjs/rangy-core "1.3.0-1"]])

(require '[boot.task-helpers]
         '[cljsjs.boot-cljsjs.packaging :refer :all])


(def +lib-version+ "1.3.0")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  push {:ensure-clean false}
  pom  {:project     'cljsjs/rangy-selectionsaverestore
        :version     +version+
        :description "A cross-browser JavaScript range and selection library"
        :url         "https://github.com/timdown/rangy"
        :license     {"MIT" "https://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url (format
                     "https://raw.githubusercontent.com/timdown/rangy/%s/lib/rangy-selectionsaverestore.js"
                     +lib-version+)
              :checksum "1794478AFD743D5225CA17F01F53C9A3")
    (sift :move {#"^rangy-selectionsaverestore\.js"
                 "cljsjs/rangy/development/rangy-selectionsaverestore.inc.js"})
    (minify :in "cljsjs/rangy/development/rangy-selectionsaverestore.inc.js"
            :out "cljsjs/rangy/production/rangy-selectionsaverestore.min.inc.js")

    (sift :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.rangy-selectionsaverestore"
               :requires ["cljsjs.rangy-core"])
    (pom)
    (jar)))
