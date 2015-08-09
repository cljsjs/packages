(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                 [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.11.1")
(def cljsjs-version "1")

(task-options!
 pom  {:project     'cljsjs/typeahead-bundle
       :version     (str +version+ "-" cljsjs-version)
       :description "A flexible JavaScript library that provides a strong foundation for building robust typeaheads."
       :url         "https://github.com/twitter/typeahead.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/twitter/typeahead.js/archive/v" +version+ ".zip")
             :unzip true)
   (sift :move {#".*?typeahead.bundle.js"     "cljsjs/typeahead-bundle/development/typeahead.inc.js"
                #".*?typeahead.bundle.min.js" "cljsjs/typeahead-bundle/production/typeahead.bundle.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.typeahead-bundle")))
