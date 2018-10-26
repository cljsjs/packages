(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                  [cljsjs/parinfer "3.11.0-0"]])

(require '[boot.task-helpers]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.4.1")
(def +version+ (str +lib-version+ "-2"))

(task-options!
  push {:ensure-clean false}
  pom  {:project     'cljsjs/parinfer-codemirror
        :version     +version+
        :description "Parinfer for CodeMirror"
        :url         "https://github.com/shaunlebron/parinfer-codemirror"
        :license     {"ISC" "https://opensource.org/licenses/ISC"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/shaunlebron/parinfer-codemirror/releases/download/%s/parinfer-codemirror.js" +lib-version+)
              :target "cljsjs/parinfer-codemirror/development/parinfer-codemirror.inc.js")

    (minify :in "cljsjs/parinfer-codemirror/development/parinfer-codemirror.inc.js"
            :out "cljsjs/parinfer-codemirror/production/parinfer-codemirror.min.inc.js")

    (sift :include #{#"^cljsjs"})

    (deps-cljs :provides ["parinfer-codemirror" "cljsjs.parinfer-codemirror"]
               :requires ["cljsjs.parinfer"]
               :global-exports '{parinfer-codemirror parinferCodeMirror})
    (validate-checksums)
    (pom)
    (jar)))
