(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.1.5")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project 'cljsjs/flatpickr
       :version +version+
       :description "Lightweight, powerful datetimepicker. zero dependencies"
       :url         "https://github.com/chmln/flatpickr"
       :scm         {:url "https://github.com/chmln/flatpickr"}
       :license     {"MIT" "https://github.com/chmln/flatpickr/blob/gh-pages/LICENSE.md"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/chmln/flatpickr/archive/v%s.zip" +lib-version+)
              :unzip true)
    (sift :move {#"^flatpickr.*/dist/flatpickr\.js" "cljsjs/flatpickr/development/flatpickr.inc.js"
                 #"^flatpickr.*/dist/(.*)\.css" "public/flatpickr/$1.css"
                 #"^flatpickr.*/dist/flatpickr\.min\.js" "cljsjs/flatpickr/production/flatpickr.min.inc.js"})
    (sift :include #{#"^cljsjs/" #"^public/"})
    (deps-cljs :name "cljsjs.flatpickr")
    (pom)
    (jar)
    (validate-checksums)))
