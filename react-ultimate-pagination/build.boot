(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]])

(def +lib-version+ "1.2.0")
(def +version+ (str +lib-version+ "-1"))
(def +lib-folder+ (format "react-ultimate-pagination-%s" +lib-version+))

(task-options!
 pom  {:project     'cljsjs/react-ultimate-pagination
       :version     +version+
       :description "React.js pagination component based on ultimate-pagination"
       :url         "https://github.com/ultimate-pagination/react-ultimate-pagination"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"GPLv3" "https://www.gnu.org/licenses/gpl-3.0.en.html"}})

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(deftask package []
   (comp
     (download :url (format "https://github.com/ultimate-pagination/react-ultimate-pagination/archive/v%s.zip" +lib-version+)
               :unzip true)
     (sift :move {#"^react-ultimate-pagination-[^/]*/" ""})
     (run-commands
       :commands [["npm" "install"]
                  ["npm" "install" "webpack"]
                  ["npm" "run" "build"]
                  ["./node_modules/.bin/webpack" "--config" "webpack.config.cljsjs.js"]])
     (sift :move {#".*react-ultimate-pagination.inc.js" "cljsjs/react-ultimate-pagination/development/react-ultimate-pagination.inc.js"})
     (sift :include #{#"^cljsjs"})

     (minify :in  "cljsjs/react-ultimate-pagination/development/react-ultimate-pagination.inc.js"
             :out "cljsjs/react-ultimate-pagination/production/react-ultimate-pagination.min.inc.js")

     (deps-cljs :provides ["react-ultimate-pagination" "cljsjs.react-ultimate-pagination"]
                :requires ["cljsjs.react"]
                :global-exports '{react-ultimate-pagination ReactUltimatePagination})
     (pom)
     (jar)
     (validate)))
