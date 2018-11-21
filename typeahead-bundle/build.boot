(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                 [cljsjs/jquery "1.9.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.11.1")
(def +version+ (str +lib-version+ "-2"))

(task-options!
 pom  {:project     'cljsjs/typeahead-bundle
       :version     +version+
       :description "A flexible JavaScript library that provides a strong foundation for building robust typeaheads."
       :url         "https://github.com/twitter/typeahead.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/twitter/typeahead.js/archive/v" +lib-version+ ".zip")
             :unzip true)
   (sift :move {#".*?typeahead.bundle.js"     "cljsjs/typeahead-bundle/development/typeahead.inc.js"
                #".*?typeahead.bundle.min.js" "cljsjs/typeahead-bundle/production/typeahead.bundle.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.typeahead-bundle"
              :requires ["cljsjs.jquery"])
   (pom)
   (jar)))
