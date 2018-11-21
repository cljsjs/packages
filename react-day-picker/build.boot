(def +lib-version+ "5.5.3")
(def +version+ (str +lib-version+ "-1"))

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
   (download :url (str "https://raw.githubusercontent.com/gpbl/react-day-picker/v" +lib-version+ "/lib/daypicker.js")
             :checksum "08293a1d77ef3b201f6b6e8ea994d465")
   (download :url (str "https://raw.githubusercontent.com/gpbl/react-day-picker/v" +lib-version+ "/lib/daypicker.min.js")
             :checksum "0022da4ce6a8d102efe62d35a0b2ee8e")
   (download :url (str "https://raw.githubusercontent.com/gpbl/react-day-picker/v" +lib-version+ "/lib/style.css")
             :checksum "d3b61e24d0595befd2b66dacc3c16d8a")
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
