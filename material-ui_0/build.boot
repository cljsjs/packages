(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]
                  [cljsjs/react "15.6.1-1"]
                  [cljsjs/react-dom "15.6.1-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.20.1")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "material-ui-%s" +lib-version+))

(task-options!
  pom {:project     'cljsjs/material-ui
       :version     +version+
       :description "A Set of React Components that Implement Google's Material Design"
       :url         "http://www.material-ui.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/mui-org/material-ui/archive/v%s.zip" +lib-version+)
              :unzip true)
    (sift :move {#"material-ui-[^/]*/" ""})
    (run-commands :commands [["npm" "install"]
                             ["npm" "install" "webpack"]
                             ["npm" "install" "babel-cli"]
                             ["npm" "run" "build:icon-index"]
                             ["node" "--stack-size=1500" "./node_modules/.bin/babel" "./src" "--ignore" "*.spec.js" "--out-dir" "./build"]
                             ["npm" "run" "build:copy-files"]
                             ["./node_modules/.bin/webpack"]
                             ["./node_modules/.bin/webpack" "--production"]
                             ["./node_modules/.bin/webpack" "--svg-icons"]
                             ["./node_modules/.bin/webpack" "--svg-icons" "--production"]
                             ["rm" "-rf" "./node_modules"]])
    (sift :move {#".*material-ui.inc.js"
                 "cljsjs/material-ui/development/material-ui.inc.js"
                 #".*material-ui-svg-icons.inc.js"
                 "cljsjs/material-ui/development/material-ui-svg-icons.inc.js"
                 #".*material-ui.min.inc.js"
                 "cljsjs/material-ui/production/material-ui.min.inc.js"
                 #".*material-ui-svg-icons.min.inc.js"
                 "cljsjs/material-ui/production/material-ui-svg-icons.min.inc.js"})
    (sift :include #{#"^cljsjs" #"^deps.cljs"})
    (deps-cljs :foreign-libs [{:file     #"material-ui.inc.js",
                               :provides ["material-ui" "material-ui/styles" "material-ui/utils" "cljsjs.material-ui"]
                               :global-exports '{"material-ui" MaterialUI
                                                 "material-ui/styles" MaterialUIStyles
                                                 "material-ui/utils" MaterialUIUtils}
                               :requires ["react" "react-dom"],
                               :file-min #"material-ui.min.inc.js"}
                              {:file     #"material-ui-svg-icons.inc.js",
                               :provides ["material-ui/svg-icons" "cljsjs.material-ui-svg-icons"],
                               :global-exports '{"material-ui/svg-icons" MaterialUISvgIcons}
                               :requires ["material-ui"],
                               :file-min #"material-ui-svg-icons.min.inc.js"}],
               :externs [#"material-ui.ext.js"
                         #"material-ui-svg-icons.ext.js"])
    (pom)
    (jar)
    (validate)))
