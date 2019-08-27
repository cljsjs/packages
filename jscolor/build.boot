(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.4")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/jscolor
       :version     +version+
       :description "web color picker component that aims to be super easy both for developers to install and end users to use."
       :url         "http://jscolor.com"
       :scm         {:url "https://github.com/EastDesire/jscolor"}
       :license     {"GPLv3" "https://www.gnu.org/licenses/gpl-3.0.txt"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/EastDesire/jscolor/archive/" +lib-version+ ".zip")
              :checksum "f35ecd99cbb4c844ad5ecd5a46ac3a57"
              :unzip true)
    (sift :move {#"^.*jscolor\.js$"       "cljsjs/jscolor/development/jscolor.inc.js"
                 #"^.*jscolor\.min\.js$"  "cljsjs/jscolor/production/jscolor.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.jscolor")
    (pom)
    (jar)))
