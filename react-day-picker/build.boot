(def +lib-version+ "7.4.8")
(def +version+ (str +lib-version+ "-0"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
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
   (download 
    :url (str "https://unpkg.com/react-day-picker@" +lib-version+ "/lib/react-day-picker.min.js")
    :target "cljsjs/react-day-picker/development/react-day-picker.inc.js")
   (download
    :url (str "https://unpkg.com/react-day-picker@" +lib-version+ "/lib/react-day-picker.min.js")
    :target "cljsjs/react-day-picker/development/react-day-picker.min.inc.js")
   (download 
    :url (str "https://unpkg.com/react-day-picker@" +lib-version+ "/lib/style.css")
    :target "cljsjs/react-day-picker/common/react-day-picker.inc.css")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.react-day-picker" :requires ["cljsjs.react"])
   (validate-checksums)
   (pom)
   (jar)))
