(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                  [cljsjs/react "16.8.3-0"]
                  [cljsjs/react-dom "16.8.3-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.0.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/material-ui
       :version     +version+
       :description "A Set of React Components that Implement Google's Material Design"
       :url         "http://www.material-ui.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://unpkg.com/@material-ui/core@" +lib-version+ "/umd/material-ui.development.js")
              :target "cljsjs/material-ui/development/material-ui.inc.js")
    (download :url (str "https://unpkg.com/@material-ui/core@" +lib-version+ "/umd/material-ui.production.min.js")
              :target "cljsjs/material-ui/production/material-ui.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.material-ui"
              :requires ["cljsjs.react"
                         "cljsjs.react.dom"])
   (pom)
   (jar)
   (validate-checksums)))
