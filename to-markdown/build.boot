(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.3.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  push {:ensure-clean false}
  pom  {:project     'cljsjs/to-markdown
        :version     +version+
        :description "An HTML to Markdown converter written in JavaScript."
        :url         "https://github.com/domchristie/to-markdown"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask package []
  (comp
    (download :url (str "https://github.com/domchristie/to-markdown/archive/v" +lib-version+  ".zip")
              :checksum "80473EB917A550436AAA2D8ADC6F0361"
              :unzip true)
    (sift :move {#"^to-markdown-(.*)/dist/to-markdown\.js"
                 "cljsjs/to-markdown/development/to-markdown.inc.js"})
    (minify :in "cljsjs/to-markdown/development/to-markdown.inc.js"
            :out "cljsjs/to-markdown/production/to-markdown.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.to-markdown")
    (pom)
    (jar)))
