(def +lib-version+ "7.3.0")
(def +version+ (str +lib-version+ "-1"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                  [cljsjs/react       "16.8.1-0"]])

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
   (download :url (str "https://unpkg.com/react-day-picker@" +lib-version+ "/lib/daypicker.min.js"))
   (download :url (str "https://unpkg.com/react-day-picker@" +lib-version+ "/lib/style.css"))
   (sift :move {#"^daypicker.min.js$"
                "cljsjs/react-day-picker/development/react-day-picker.inc.js"
                #"^daypicker.min.js$"
                "cljsjs/react-day-picker/development/react-day-picker.min.inc.js"
                #"^style.css$"
                "cljsjs/react-day-picker/common/react-day-picker.inc.css"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.react-day-picker" :requires ["cljsjs.react"])
   (validate-checksums)
   (pom)
   (jar)))
