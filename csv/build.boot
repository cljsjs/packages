(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/csv
        :version     +version+
        :description "A Comma-Separated Values parser for JavaScript. Standards-based, stand alone, and no regular expressions."
        :url         "http://gkindel.github.io/CSV-JS/csv.html"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/gkindel/CSV-JS/archive/v" +lib-version+ ".zip")
              :checksum "3524058521147def3fddcc6c93d63249"
              :unzip true)
    (sift :move {#"^CSV-JS-.*/csv.js" "cljsjs/development/csv.inc.js"})
    (minify :in "cljsjs/development/csv.inc.js" :out "cljsjs/production/csv.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.csv")))
