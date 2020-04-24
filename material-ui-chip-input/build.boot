(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]
                  [cljsjs/react "16.12.0-2"]
                  [cljsjs/react-dom "16.12.0-2"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/material-ui-chip-input
       :version     +version+
       :description "A chip input field using Material-UI."
       :url         "https://github.com/TeamWertarbyte/material-ui-chip-input"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"GPLv3" "https://www.gnu.org/licenses/gpl-3.0.en.html"}})

(deftask package []
   (comp
    (run-commands :commands [["npm" "install" "--include-dev"]
                             ["npm" "run" "build:dev"]
                             ["npm" "run" "build:prod"]
                             ["rm" "-rf" "./node_modules"]])
     (sift :move {#".*material-ui-chip-input.inc.js" "cljsjs/material-ui-chip-input/development/material-ui-chip-input.inc.js"
                  #".*material-ui-chip-input.min.inc.js" "cljsjs/material-ui-chip-input/production/material-ui-chip-input.min.inc.js"})
     (sift :include #{#"^cljsjs"})
     (deps-cljs :foreign-libs [{:file #"material-ui-chip-input.inc.js"
                                :file-min #"material-ui-chip-input.min.inc.js"
                                :provides ["@material-ui/ChipInput"
                                           "material-ui-chip-input"
                                           "cljsjs.material-ui-chip-input"]
                                :global-exports '{"@material-ui/ChipInput" MaterialUIChipInput}
                                :requires ["react" "react-dom" "@material-ui/core"]
                                :externs [#"material-ui-chip-input.ext.js"]}])
     (pom)
     (jar)
    (validate-checksums)))
