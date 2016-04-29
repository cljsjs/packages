(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.3.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/js-yaml
        :version     +version+
        :description "JavaScript YAML parser and dumper. Very fast."
        :url         "http://nodeca.github.com/js-yaml/"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/nodeca/js-yaml/archive/%s.zip" +lib-version+)
              :checksum "812fa1a884c5a633d88b10634ca91ba9"
              :unzip true)
    (sift :move {#"^js-yaml-.*/dist/js-yaml.js" "cljsjs/development/js-yaml.inc.js"})
    (sift :move {#"^js-yaml-.*/dist/js-yaml.min.js" "cljsjs/production/js-yaml.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.js-yaml")
    (pom)
    (jar)))
