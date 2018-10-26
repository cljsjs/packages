(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.7.7")
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
    (download :url (cdn-ver "ajv.bundle.js")
              :checksum "F453B6BC9BAB6BDD07968CD767F6EDF1")
    (download :url (cdn-ver "ajv.min.js")
              :checksum "C4E86C8C3CCE66F24E2CA04256D26B8A")
    (sift :move {#"ajv.bundle.js"  "cljsjs/ajv/development/ajv.inc.js"
                 #"ajv.min.js"     "cljsjs/ajv/production/ajv.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.ajv")
    (pom)
    (jar)))
