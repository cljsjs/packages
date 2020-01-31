(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]
                  [cljsjs/react "15.4.2-2"]
                  [cljsjs/lodash "4.11.2-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "1.2.0")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "reactcss-%s" +lib-version+))

(task-options!
 pom  {:project     'cljsjs/reactcss
       :version     +version+
       :description "Inline styles in JS with React and React Native support"
       :url         "http://reactcss.com/"
       :scm         {:url "https://github.com/casesandberg/reactcss"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask download-reactcss []
  (download  :url      (format "https://github.com/casesandberg/reactcss/archive/%s.zip" +lib-version+)
             :checksum "e837182dfdce087401879e7e283cf495"
             :unzip    true))

(def webpack-file-name "webpack.config.js")

(deftask build []
         (let [tmp (boot/tmp-dir!)]
              (with-pre-wrap
                fileset
                (doseq [f (boot/input-files fileset)]
                       (let [target (io/file tmp (tmpd/path f))]
                            (io/make-parents target)
                            (io/copy (tmpd/file f) target)))
                (io/copy
                  (io/file tmp "webpack.config.js")
                  (io/file tmp +lib-folder+ "webpack-cljsjs.config.js"))
                (binding [*sh-dir* (str (io/file tmp +lib-folder+))]
                         ((sh "npm" "install" "--ignore-scripts"))
                         ((sh "npm" "install" "webpack"))
                         ((sh "./node_modules/.bin/webpack" "--config" "webpack-cljsjs.config.js")))
                (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
   (download-reactcss)
   (build)
   (sift :move {#".*reactcss.inc.js" "cljsjs/reactcss/development/reactcss.inc.js"})
   (sift :include #{#"^cljsjs"})

   (minify :in  "cljsjs/reactcss/development/reactcss.inc.js"
           :out "cljsjs/reactcss/production/reactcss.min.inc.js")   ;; :lang :ecmascript5

   (deps-cljs :name "cljsjs.reactcss" :requires ["cljsjs.react" "cljsjs.lodash"])
   (pom)
   (jar)))
