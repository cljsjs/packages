(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.7.1" :scope "test"]])

(require '[boot.task-helpers]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.4.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  push {:ensure-clean false}
  pom  {:project     'cljsjs/parinfer-codemirror
        :version     +version+
        :description "Parinfer for CodeMirror"
        :url         "https://github.com/shaunlebron/parinfer-codemirror"
        :license     {"ISC" "https://opensource.org/licenses/ISC"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask package []
  (comp
    (download :url (format
                     "https://github.com/shaunlebron/parinfer-codemirror/releases/download/%s/parinfer-codemirror.js"
                     +lib-version+)
              :checksum "21FBA7FF0C8D30D5D135E368CD215F0D")

    (sift :move {#"^parinfer-codemirror\.js"
                 "cljsjs/parinfer-codemirror/development/parinfer-codemirror.inc.js"})

    (minify :in "cljsjs/parinfer-codemirror/development/parinfer-codemirror.inc.js"
            :out "cljsjs/parinfer-codemirror/production/parinfer-codemirror.min.inc.js")

    (sift :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.parinfer-codemirror")
    (pom)
    (jar)))
