(def +lib-version+ "2.4.1")
(def +version+ (str +lib-version+ "-0"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]
                  [cljsjs/react       "15.3.1-0" :scope "provided"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])


(task-options!
 pom  {:project     'cljsjs/react-day-picker
       :version     +version+
       :description "A date picker component"
       :url         "https://github.com/gpbl/react-day-picker"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package  []
  (task-options! push {:ensure-branch nil :tag false})
  (comp
    (download :url (str "https://raw.githubusercontent.com/gpbl/react-day-picker/v" +lib-version+ "/dist/DayPicker.js")
              :checksum "0F90D0E05603015BE9C41153A986F38D")
    (download :url (str "https://raw.githubusercontent.com/gpbl/react-day-picker/v" +lib-version+ "/src/style.css")
              :checksum "4CEDAFC0F76D42F8574B6240374CE7DA")
    (sift :move {#"^DayPicker.js$"
                 "cljsjs/react-day-picker/development/react-day-picker.inc.js"

                 #"^style.css$"
                 "cljsjs/react-day-picker/common/react-day-picker.inc.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-day-picker" :requires ["cljsjs.react"])
    (pom)
    (jar)))
