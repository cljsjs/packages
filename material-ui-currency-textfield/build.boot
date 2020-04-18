(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                  [cljsjs/material-ui "4.4.1-0"]
                  [cljsjs/prop-types  "15.7.2-0"]
                  [cljsjs/react       "16.8.6-0"]
                  [cljsjs/react-dom   "16.8.6-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.8.6")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/material-ui-currency-textfield
       :version     +version+
       :description "Currency input textfield for react with Material-ui style"
       :url         "https://unicef.github.io/material-ui-currency-textfield"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (run-commands :commands [["npm" "install"]
                             ["npm" "run" "build:dev"]
                             ["npm" "run" "build:prod"]
                             ["rm" "-rf" "node_modules" "package-lock.json"]])

    (deps-cljs :name "cljsjs.material-ui-currency-textfield"
               :requires ["cljsjs.material-ui"
                          "cljsjs.prop-types"
                          "cljsjs.react"
                          "cljsjs.react.dom"])

    (pom)
    (jar)
    (validate-checksums)))
