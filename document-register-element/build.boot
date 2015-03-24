(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.7" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.2.1-0")

(task-options!
 pom  {:project     'cljsjs/document-register-element
       :version     +version+
       :description "A stand-alone working lightweight version of the W3C Custom Elements specification"
       :url         "https://github.com/WebReflection/document-register-element"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url "https://cdnjs.cloudflare.com/ajax/libs/document-register-element/0.2.1/document-register-element.js")
    (download :url "https://cdnjs.cloudflare.com/ajax/libs/document-register-element/0.2.1/document-register-element.max.js")
    (sift :move {#"document-register-element.max.js" "cljsjs/development/document-register-element.inc.js"
                 #"document-register-element.js" "cljsjs/production/document-register-element.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :no-externs true :name "cljsjs.document-register-element")))
