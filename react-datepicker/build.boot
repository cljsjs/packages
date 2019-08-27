(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]
                 [cljsjs/react "16.8.1-0"]
                 [cljsjs/date-fns "1.29.0-0"]
                 [cljsjs/react-dom "16.8.1-0"]
                 [cljsjs/prop-types "15.6.1-0"]
                 [cljsjs/moment "2.22.0-0"]
                 [cljsjs/react-popper "1.0.2-0"]
                 [cljsjs/classnames "2.2.5-1"]
                 [cljsjs/react-onclickoutside "6.7.1-1"]])

  (def +lib-version+ "2.3.0")
(def +version+ (str +lib-version+ "-0"))

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/react-datepicker
       :version     +version+
       :description "A simple and reusable datepicker component for React"
       :url         "http://hacker0x01.github.io/react-datepicker"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/react-datepicker@%s/dist/react-datepicker.js" +lib-version+)
             :target "cljsjs/react-datepicker/development/react-datepicker.inc.js")
   (download :url (format "https://unpkg.com/react-datepicker@%s/dist/react-datepicker.css" +lib-version+)
             :target "cljsjs/react-datepicker/development/react-datepicker.inc.css")
   (download :url (format "https://unpkg.com/react-datepicker@%s/dist/react-datepicker.min.js" +lib-version+)
             :target "cljsjs/react-datepicker/production/react-datepicker.min.inc.js")
   (download :url (format "https://unpkg.com/react-datepicker@%s/dist/react-datepicker.min.css" +lib-version+)
             :target "cljsjs/react-datepicker/production/react-datepicker.min.inc.css")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.react-datepicker"
              :requires ["cljsjs.react"
                         "cljsjs.react.dom"
                         "cljsjs.prop-types"
                         "cljsjs.classnames"
                         "cljsjs.moment"
                         "cljsjs.react-popper"
                         "cljsjs.react-onclickoutside"])
   (pom)
   (jar)
   (validate)))
