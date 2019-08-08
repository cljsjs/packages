(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]
                  [cljsjs/jquery      "3.2.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.0.0-beta.30")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/uikit
        :version     +version+
        :description "A lightweight and modular front-end framework for developing fast and powerful web interfaces."
        :url         "https://github.com/uikit/uikit"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (format "https://github.com/uikit/uikit/archive/v%s.zip" +lib-version+)
             :checksum "F0B0B613E241A43CB8811099C4BF69A9"
             :unzip true)
    (sift :move {(re-pattern (str "uikit-" +lib-version+ "/dist/js/uikit.js"))           "cljsjs/uikit/development/uikit.inc.js"
                 (re-pattern (str "uikit-" +lib-version+ "/dist/js/uikit-icons.js"))     "cljsjs/uikit/development/uikit-icons.inc.js"
                 (re-pattern (str "uikit-" +lib-version+ "/dist/css/uikit.css"))         "cljsjs/uikit/development/uikit.inc.css"
                 (re-pattern (str "uikit-" +lib-version+ "/dist/css/uikit-rtl.css"))     "cljsjs/uikit/development/uikit-rtl.inc.css"
                 (re-pattern (str "uikit-" +lib-version+ "/dist/js/uikit.min.js"))       "cljsjs/uikit/production/uikit.min.inc.js"
                 (re-pattern (str "uikit-" +lib-version+ "/dist/js/uikit-icons.min.js")) "cljsjs/uikit/production/uikit-icons.min.inc.js"
                 (re-pattern (str "uikit-" +lib-version+ "/dist/css/uikit.min.css"))     "cljsjs/uikit/production/uikit.min.inc.css"
                 (re-pattern (str "uikit-" +lib-version+ "/dist/css/uikit-rtl.min.css")) "cljsjs/uikit/production/uikit-rtl.min.inc.css"})
   (sift :include #{#"^cljsjs" #"^deps.cljs$"})
   (pom)
   (jar)))
