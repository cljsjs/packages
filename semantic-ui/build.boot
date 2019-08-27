(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]
                  [cljsjs/jquery "2.2.2-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.4.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/semantic-ui
        :version     +version+
        :description "Semantic UI jquery behaviors."
        :url         "http://semantic-ui.com"
        :scm         {:url "https://github.com/cljsjs/packages"}
        :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download
      :url (format "https://github.com/Semantic-Org/Semantic-UI/archive/%s.zip" +lib-version+)
      :unzip true)
    (sift :move {#"^Semantic-UI-.*/dist/semantic.js$"     "cljsjs/semantic-ui/development/semantic.inc.js"
                 #"^Semantic-UI-.*/dist/semantic.min.js$" "cljsjs/semantic-ui/production/semantic.min.inc.js"
                 #"^Semantic-UI-.*/dist/([^/]+\.css)$"    "cljsjs/semantic-ui/common/$1"
                 #"^Semantic-UI-.*/dist/themes/(.*)$"     "cljsjs/semantic-ui/common/themes/$1"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs
      :name "cljsjs.semantic-ui"
      :requires ["cljsjs.jquery"])
    (pom)
    (jar)
    (validate)))
