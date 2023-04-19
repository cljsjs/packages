(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                  [cljsjs/moment "2.17.1-0"]])

(require '[boot.task-helpers]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.5.11")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  push {:ensure-clean false}
  pom  {:project     'cljsjs/moment-timezone
        :version     +version+
        :description "A javascript date library for parsing, validating, manipulating, and formatting dates."
        :url         "http://momentjs.com/timezone"
        :license     {"MIT" ""}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url (format "https://cdnjs.cloudflare.com/ajax/libs/moment-timezone/%s/moment-timezone-with-data.js" +lib-version+))
    (download :url (format "https://cdnjs.cloudflare.com/ajax/libs/moment-timezone/%s/moment-timezone-with-data.min.js" +lib-version+))


    (sift :move {#"^moment-timezone-with-data\.js"          "cljsjs/moment-timezone/development/moment-timezone.inc.js"
                 #"^moment-timezone-with-data\.min\.js"     "cljsjs/moment-timezone/production/moment-timezone.min.inc.js"})

    (sift :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.moment-timezone"
               :requires #{"cljsjs.moment"})
    (pom)
(jar)))
