(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.0")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  pom  {:project     'cljsjs/optiscroll
        :version     +version+
        :description (str "Optiscroll is a tiny (9kb) and highly optimized "
                          "custom scrollbar library for modern web apps.")
        :url         "https://github.com/albertogasparin/Optiscroll"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/albertogasparin/Optiscroll"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/albertogasparin/Optiscroll/archive/v" +lib-version+ ".zip")
              :checksum "326b1a797f1b1982cd3212fc1fc78e43"
              :unzip true)
    (sift :move {#"^Optiscroll-([\d.]*)/dist/optiscroll\.css" "cljsjs/optiscroll/development/optiscroll.inc.css"
                 #"^Optiscroll-([\d.]*)/dist/optiscroll\.js" "cljsjs/optiscroll/development/optiscroll.inc.js"
                 #"^Optiscroll-([\d.]*)/dist/optiscroll\.min\.js" "cljsjs/optiscroll/production/optiscroll.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.optiscroll")
    (pom)
    (jar)))
