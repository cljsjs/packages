(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]
                  [cljsjs/jquery "1.9.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.0.3")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  pom  {:project     'cljsjs/select2
        :version     +version+
        :description "Select2 is a jQuery-based replacement for select boxes. It supports searching, remote data sets, and pagination of results."
        :url         "https://github.com/select2/select2"
        :scm         {:url "https://github.com/cljsjs/packages"}
        :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/select2/select2/archive/" +lib-version+ ".zip")
              :unzip true)
    (sift :move {#".*/dist/js/select2.full.js"     "cljsjs/select2/development/select2.inc.js"
                 #".*/dist/js/select2.full.min.js" "cljsjs/select2/production/select2.min.inc.js"
                 #".*/dist/css/select2.css"        "cljsjs/select2/development/select2.inc.css"
                 #".*/dist/css/select2.min.css"    "cljsjs/select2/production/select2.min.inc.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.select2"
               :requires ["cljsjs.jquery"])
    (pom)
    (jar)))
