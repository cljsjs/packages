(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.3.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project 'cljsjs/react-bootstrap-table
       :version +version+
       :description "It's a react.js table for bootstrap, named react-bootstrap-table."
       :url "https://github.com/AllenFang/react-bootstrap-table"
       :license {"MIT" "https://github.com/AllenFang/react-bootstrap-table/blob/master/LICENSE"}
       :scm {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url
             (format "https://github.com/AllenFang/react-bootstrap-table/archive/v%s.zip" +lib-version+)
             :checksum "12487a940498c997498749c3ed02c75d"
             :unzip true)
   (sift :move {#"^react-bootstrap-table-.*/dist/react-bootstrap-table\.js"
                "cljsjs/react-bootstrap-table/development/react-bootstrap-table.inc.js"

                #"^react-bootstrap-table-.*/dist/react-bootstrap-table.min.js" "cljsjs/react-bootstrap-table/production/react-bootstrap-table.min.inc.js"

                #"^react-bootstrap-table-.*/dist/react-bootstrap-table-all\.min\.css"
                "cljsjs/react-bootstrap-table/common/react-bootstrap-table.css"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.react-bootstrap-table")
   (pom)
   (jar)))
