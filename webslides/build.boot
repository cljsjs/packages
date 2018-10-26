(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.5.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/webslides
        :version     +version+
        :description "Create HTML presentations in seconds"
        :url         "http://webslides.tv"
        :scm         {:url "https://github.com/cljsjs/packages"}
        :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download
      :url (format "https://github.com/webslides/webslides/archive/%s.zip" +lib-version+)
      :unzip true)
    (sift :move {#"^WebSlides-.*/static/js/webslides.js$"     "cljsjs/webslides/development/webslides.inc.js"
                 #"^WebSlides-.*/static/js/webslides.min.js$" "cljsjs/webslides/production/webslides.min.inc.js"
                 #"^WebSlides-.*/static/css/([^/]+\.css)$"    "cljsjs/webslides/common/$1"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs
      :name "cljsjs.webslides")
    (pom)
    (jar)
    (validate-checksums)))
