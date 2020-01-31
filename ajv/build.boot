(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "6.10.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/ajv
       :version     +version+
       :description "The fastest JSON Schema validator"
       :url         "http://epoberezkin.github.io/ajv/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/mit-license.php"}})

(defn cdn-ver [file]
  (str "https://cdnjs.cloudflare.com/ajax/libs/ajv/" +lib-version+ "/" file))

(deftask package []
  (comp
    (download :url (cdn-ver "ajv.bundle.js"))
    (download :url (cdn-ver "ajv.min.js"))
    (sift :move {#"ajv.bundle.js"  "cljsjs/ajv/development/ajv.inc.js"
                 #"ajv.min.js"     "cljsjs/ajv/production/ajv.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.ajv")
    (pom)
    (jar)
    (validate-checksums)))
