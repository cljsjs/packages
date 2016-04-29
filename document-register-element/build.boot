(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.5.3")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/document-register-element
       :version     +version+
       :description "A stand-alone working lightweight version of the W3C Custom Elements specification"
       :url         "https://github.com/WebReflection/document-register-element"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/document-register-element/" +lib-version+ "/document-register-element.js"))
    (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/document-register-element/" +lib-version+ "/document-register-element.max.js"))
    (sift :move {#"document-register-element.max.js" "cljsjs/document-register-element/development/document-register-element.inc.js"
                 #"document-register-element.js" "cljsjs/document-register-element/production/document-register-element.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :no-externs true :name "cljsjs.document-register-element")
    (pom)
    (jar)))
