(def +lib-version+ "7.3.0")
(def +version+ (str +lib-version+ "-0"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
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
   (download :url (str "https://unpkg.com/react-day-picker@" +lib-version+ "/lib/daypicker.js")
             :checksum "DA84C5960DB04F7D89D7F9817D06E720")
   (download :url (str "https://unpkg.com/react-day-picker@" +lib-version+ "/lib/daypicker.min.js")
             :checksum "84E031CF3FAD5116E11A68DE484EA128")
   (download :url (str "https://unpkg.com/react-day-picker@" +lib-version+ "/lib/style.css")
             :checksum "F85DB4BA3CDA17D70FD882F2EFF3689A")
   (sift :move {#"^daypicker.js$"
                "cljsjs/react-day-picker/development/react-day-picker.inc.js"

                #"^daypicker.min.js$"
                "cljsjs/react-day-picker/development/react-day-picker.min.inc.js"

                #"^style.css$"
                "cljsjs/react-day-picker/common/react-day-picker.inc.css"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.react-day-picker" :requires ["cljsjs.react"])
   (pom)
   (jar)))
