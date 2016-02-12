(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/material
       :version     +version+
       :description "Material Design Lite is a lightweight HTML, CSS and JS framework for sites that follow Google's Material Design guidelines."
       :url         "https://www.getmdl.io"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache-2.0" "http://opensource.org/licenses/Apache-2.0"}})

(deftask package []
  (task-options! push {:ensure-branch nil})
  (comp
    (download :url (str "https://github.com/google/material-design-lite/archive/v" +lib-version+ ".zip")
              :checksum "594EEF0EA44AA7F2B2F51185460743A2"
              :unzip true)
    (sift :move {(re-pattern (str "^material-design-lite-" +lib-version+ "/material.js$"))        "cljsjs/material/development/material.inc.js"
                 (re-pattern (str "^material-design-lite-" +lib-version+ "/material.css$"))        "cljsjs/material/development/material.inc.css"
                 (re-pattern (str "^material-design-lite-" +lib-version+ "/material.min.js$"))   "cljsjs/material/production/material.min.inc.js"
                 (re-pattern (str "^material-design-lite-" +lib-version+ "/material.min.css$")) "cljsjs/material/production/material.min.inc.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.material")))
