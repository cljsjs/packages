(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]
                  [cljsjs/react "0.14.3-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.14.4")
(def +version+ (str +lib-version+ "-10"))

(task-options!
  pom {:project     'cljsjs/material-ui
       :version     +version+
       :description "A Set of React Components that Implement Google's Material Design"
       :url         "http://www.material-ui.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(def url (format "https://github.com/madvas/material-ui-bundle/archive/v%s.zip" +lib-version+))
(deftask download-material-ui []
         (download :url url
                   :checksum "2471e4b9df750fba75e0837f7ea960fb"
                   :unzip true))

(deftask package []
         (comp
           (download-material-ui)
           (sift :move {#".*material-ui.inc.js"
                        "cljsjs/material-ui/development/material-ui.inc.js"
                        #".*material-ui.min.inc.js"
                        "cljsjs/material-ui/production/material-ui.min.inc.js"
                        #".*material-ui-svg-icons.inc.js"
                        "cljsjs/material-ui/development/material-ui-svg-icons.inc.js"
                        #".*material-ui-svg-icons.min.inc.js"
                        "cljsjs/material-ui/production/material-ui-svg-icons.min.inc.js"
                        })
           (sift :include #{#"^cljsjs" #"^deps.cljs"})
           (pom)
           (jar)))
