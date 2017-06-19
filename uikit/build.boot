(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]
                  [cljsjs/jquery    "3.2.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.0.0-beta.25")
(def +version+ (str +lib-version+ "-1"))

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
             :checksum "B011CAB7E101870D2356A6DF220D5191"
             :unzip true)
    (sift :move {(re-pattern (str "uikit-" +lib-version+ "/dist/js/uikit.js"))           "cljsjs/development/uikit.inc.js"
                 (re-pattern (str "uikit-" +lib-version+ "/dist/js/uikit-icons.js"))     "cljsjs/development/uikit-icons.inc.js"
                 (re-pattern (str "uikit-" +lib-version+ "/dist/css/uikit.css"))         "cljsjs/development/uikit.inc.css"
                 (re-pattern (str "uikit-" +lib-version+ "/dist/css/uikit-rtl.css"))     "cljsjs/development/uikit-rtl.inc.css"
                 (re-pattern (str "uikit-" +lib-version+ "/dist/js/uikit.min.js"))       "cljsjs/production/uikit.min.inc.js"
                 (re-pattern (str "uikit-" +lib-version+ "/dist/js/uikit-icons.min.js")) "cljsjs/production/uikit-icons.min.inc.js"
                 (re-pattern (str "uikit-" +lib-version+ "/dist/css/uikit.min.css"))     "cljsjs/production/uikit.min.inc.css"
                 (re-pattern (str "uikit-" +lib-version+ "/dist/css/uikit-rtl.min.css")) "cljsjs/production/uikit-rtl.min.inc.css"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.uikit"
              :requires ["cljsjs.jquery"])
   (pom)
   (jar)))
