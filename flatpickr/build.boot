(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.5.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project 'cljsjs/flatpickr
       :version +version+
       :description "Lightweight, powerful datetimepicker. zero dependencies"
       :url         "https://github.com/chmln/flatpickr"
       :scm         {:url "https://github.com/flatpickr/flatpickr"}
       :license     {"MIT" "https://github.com/flatpickr/flatpickr/blob/gh-pages/LICENSE.md"}})

(deftask package []
  (comp
    (download :url (format "https://cdn.jsdelivr.net/npm/flatpickr@%s/dist/flatpickr.js" +lib-version+)
              :target "cljsjs/flatpickr/development/flatpickr.inc.js")
    (download :url (format "https://cdn.jsdelivr.net/npm/flatpickr@%s/dist/flatpickr.css" +lib-version+)
              :target "cljsjs/flatpickr/development/flatpickr.inc.css")
    (download :url (format "https://cdn.jsdelivr.net/npm/flatpickr@%s/dist/flatpickr.min.js" +lib-version+)
              :target "cljsjs/flatpickr/production/flatpickr.min.inc.js")
    (download :url (format "https://cdn.jsdelivr.net/npm/flatpickr@%s/dist/flatpickr.min.css" +lib-version+)
              :target "cljsjs/flatpickr/production/flatpickr.min.inc.css")
    (sift :include #{#"^cljsjs/" #"^public/"})
    (deps-cljs :name "cljsjs.flatpickr")
    (validate)
    (pom)
    (jar)))
