(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.3.5")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  push {:ensure-clean false}
  pom  {:project     'cljsjs/marked
        :version     +version+
        :description "A markdown parser and compiler. Built for speed."
        :url         "https://github.com/chjj/marked"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask package []
  (comp
    (download :url (format "https://github.com/chjj/marked/archive/v%s.zip" +lib-version+)
              :checksum "989c318bc90eddad1182dd7268d2ab72"
              :unzip true)
    (sift :move {#"^marked-(.*)/lib/marked\.js"  "cljsjs/development/marked.inc.js"
                 #"^marked-(.*)/marked\.min\.js" "cljsjs/production/marked.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.marked")
    (pom)
    (jar)))
