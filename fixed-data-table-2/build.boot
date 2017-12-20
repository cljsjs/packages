(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs        "0.9.0"  :scope "test"]
                 [cljsjs/react              "0.14.4-0"]
                 [cljsjs/react-dom          "0.14.4-0"]
                 [cljsjs/object-assign-shim "0.1.0-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.8.8")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/fixed-data-table-2
       :version     +version+
       :description "A fork of the no longer maintained table component, designed to present millions of rows of data."
       :url         "https://github.com/schrodinger/fixed-data-table-2"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask download-fixed-data-table-2 []
  (download :url      (format "https://github.com/schrodinger/fixed-data-table-2/archive/v%s.zip" +lib-version+)
            :checksum "88142ef7241911887bacc96a4ba62be4"
            :unzip    true))

(deftask package []
  (comp
    (download-fixed-data-table-2)
    (sift :move {#"^fixed-data-table-.*/dist/fixed-data-table.js"
                 "cljsjs/development/fixed-data-table.inc.js"
                 #"^fixed-data-table-.*/dist/fixed-data-table.css"
                 "cljsjs/development/fixed-data-table.inc.css"
                 #"^fixed-data-table-.*/dist/fixed-data-table-base.css"
                 "cljsjs/development/fixed-data-table-base.inc.css"
                 #"^fixed-data-table-.*/dist/fixed-data-table-style.css"
                 "cljsjs/development/fixed-data-table-style.inc.css"
                 #"^fixed-data-table-.*/dist/fixed-data-table.min.js"
                 "cljsjs/production/fixed-data-table.min.inc.js"
                 #"^fixed-data-table-.*/dist/fixed-data-table.min.css"
                 "cljsjs/production/fixed-data-table.min.inc.css"
                 #"^fixed-data-table-.*/dist/fixed-data-table-base.min.css"
                 "cljsjs/production/fixed-data-table-base.min.inc.css"
                 #"^fixed-data-table-.*/dist/fixed-data-table-style.min.css"
                 "cljsjs/production/fixed-data-table-style.min.inc.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.fixed-data-table-2"
               :requires ["cljsjs.react" "cljsjs.react.dom" "cljsjs.object-assign-shim"])
    (pom)
    (jar)))

(comment
  (boot "package" "install" "target")

  )
