(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.11" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.8" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.4.1")
(def +version+ (str +lib-version+ "-0"))

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
    (sift :move {#"document-register-element.max.js" "cljsjs/development/document-register-element.inc.js"
                 #"document-register-element.js" "cljsjs/production/document-register-element.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :no-externs true :name "cljsjs.document-register-element")))
