(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]
                  [cljsjs/bootstrap "3.3.6-1"]
                  [cljsjs/jquery "3.2.1-0"]
                  [cljsjs/typeahead-bundle "0.11.1-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.0.2")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  pom  {:project     'cljsjs/bootstrap-typeahead
        :version     +version+
        :description "A flexible JavaScript library that provides a strong foundation for building robust typeaheads."
        :url         "https://github.com/bassjobsen/Bootstrap-3-Typeahead"
        :scm         {:url "https://github.com/cljsjs/packages"}
        :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/bassjobsen/Bootstrap-3-Typeahead/archive/" +lib-version+ ".zip")
              :unzip true)
    (sift :move {#".*?bootstrap3-typeahead\.js"      "cljsjs/bootstrap-typeahead/development/bootstrap-typeahead.inc.js"
                 #".*?bootstrap3-typeahead\.min\.js" "cljsjs/bootstrap-typeahead/production/bootstrap-typeahead.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.bootstrap-typeahead"
               :requires ["cljsjs.jquery"
                          "cljsjs.typeahead-bundle"
                          "cljsjs.bootstrap"])
    (pom)
    (jar)))
