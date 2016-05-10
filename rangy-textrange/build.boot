(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]
                  [cljsjs/rangy-core "1.3.0-1"]])

(require '[boot.task-helpers]
         '[cljsjs.boot-cljsjs.packaging :refer :all])


(def +lib-version+ "1.3.0")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  push {:ensure-clean false}
  pom  {:project     'cljsjs/rangy-textrange
        :version     +version+
        :description "A cross-browser JavaScript range and selection library"
        :url         "https://github.com/timdown/rangy"
        :license     {"MIT" "https://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url (format
                     "https://raw.githubusercontent.com/timdown/rangy/%s/lib/rangy-textrange.js"
                     +lib-version+)
              :checksum "9285a26252301263bd14367af903029c")
    (sift :move {#"^rangy-textrange\.js"
                 "cljsjs/rangy/development/rangy-textrange.inc.js"})
    (minify :in "cljsjs/rangy/development/rangy-textrange.inc.js"
            :out "cljsjs/rangy/production/rangy-textrange.min.inc.js")

    (sift :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.rangy-textrange"
               :requires ["cljsjs.rangy-core"])
    (pom)
    (jar)))
