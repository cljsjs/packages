(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                 [cljsjs/jquery      "2.1.4-0"]
                 [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.11.1")


(task-options!
 pom  {:project     'cljsjs/typeahead-bundle
       :version     +version+
       :description "A flexible JavaScript library that provides a strong foundation for building robust typeaheads."
       :url         "https://github.com/twitter/typeahead.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask files []
  (with-pre-wrap fileset
    (println fileset)
    fileset))

(deftask package []
  (comp
   (download :url (str "https://github.com/twitter/typeahead.js/archive/v" +version+ ".zip")
             :unzip true)
   (sift :move {#".*?typeahead.bundle.js"     "cljsjs/typeahead-bundle/development/typeahead.inc.js"
                #".*?typeahead.bundle.min.js" "cljsjs/typeahead-bundle/production/typeahead.bundle.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.typeahead-bundle"
              :requires ["cljsjs.jquery"])))
