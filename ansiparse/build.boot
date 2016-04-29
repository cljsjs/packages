(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.0.5-1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/ansiparse
        :version     +version+
        :description "Parse ANSI color codes"
        :url         "https://github.com/mmalecki/ansiparse"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/mmalecki/ansiparse"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/mmalecki/ansiparse/archive/v" +lib-version+ ".zip")
              :unzip true)
    (sift :move {#"^ansiparse-.*/lib/ansiparse.js" "cljsjs/development/ansiparse.inc.js"})
    (minify :in "cljsjs/development/ansiparse.inc.js" :out "cljsjs/production/ansiparse.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.ansiparse")
    (pom)
    (jar)))
