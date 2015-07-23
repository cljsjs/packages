(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "3.3.1-0")

(task-options!
  pom  {:project     'cljsjs/js-yaml
        :version     +version+
        :description "JavaScript YAML parser and dumper. Very fast."
        :url         "http://nodeca.github.com/js-yaml/"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url "https://github.com/nodeca/js-yaml/archive/3.3.1.zip"
              :checksum "812fa1a884c5a633d88b10634ca91ba9"
              :unzip true)
    (sift :move {#"^js-yaml-.*/dist/js-yaml.js" "cljsjs/development/js-yaml.inc.js"})
    (sift :move {#"^js-yaml-.*/dist/js-yaml.min.js" "cljsjs/production/js-yaml.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.js-yaml"))) 
