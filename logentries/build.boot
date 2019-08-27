(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.0.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/logentries
       :version     +version+
       :description "Javascript library for Logentries.com"
       :url         "https://github.com/rapid7/le_js"
       :scm         {:url "https://github.com/rapid7/le_js"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url "https://cdnjs.cloudflare.com/ajax/libs/le_js/0.0.3/le.js" :checksum "963F263FF9EFAA1C615246897FE3E8DC")
    (download :url "https://cdnjs.cloudflare.com/ajax/libs/le_js/0.0.3/le.min.js" :checksum "C5416B6BEAA1E9AAC90EA9EF52894B1D")
    (sift :move {(re-pattern (str "le\\.min\\.js$")) "cljsjs/merge/production/le.min.inc.js"})
    (sift :move {(re-pattern (str "le\\.js$")) "cljsjs/merge/development/le.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.logentries")
    (pom)
    (jar)))
