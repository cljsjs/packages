(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.19.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/axios
       :version     +version+
       :description "Promise based HTTP client for the browser and node.js"
       :url         "https://github.com/axios/axios"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://unpkg.com/axios@" +lib-version+ "/dist/axios.js")
             :target "cljsjs/axios/development/axios.inc.js")
   (download :url (str "https://unpkg.com/axios@" +lib-version+ "/dist/axios.min.js")
             :target "cljsjs/axios/production/axios.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.axios")
   (pom)
   (jar)
   (validate)))
