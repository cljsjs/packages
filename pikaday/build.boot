(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]
                  [cljsjs/moment "2.6.0-3"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.4.0")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  pom {:project 'cljsjs/pikaday
       :version +version+
       :description "A refreshing JavaScript Datepicker - lightweight, no dependencies, modular CSS"
       :url         "https://github.com/dbushell/Pikaday"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"
                     "BSD" "http://opensource.org/licenses/BSD-2-Clause"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/dbushell/Pikaday/archive/" +lib-version+ ".zip")
              :checksum "12766879AC4E23CE71768FE8A706C4A7"
              :unzip true)
    (sift :move {#"^Pikaday.*/pikaday\.js"        "cljsjs/pikaday/development/pikaday.inc.js"
                 #"^Pikaday.*/scss/pikaday\.scss" "cljsjs/pikaday/development/pikaday.scss"
                 #"^Pikaday.*/css/pikaday\.css"   "cljsjs/pikaday/development/pikaday.css"})
    (minify :in  "cljsjs/pikaday/development/pikaday.inc.js"
            :out "cljsjs/pikaday/production/pikaday.min.inc.js")
    (minify :in  "cljsjs/pikaday/development/pikaday.css"
            :out "cljsjs/pikaday/production/pikaday.min.css")
    (sift :include #{#"^cljsjs/" #"^deps.cljs$"})
    (pom)
    (jar)))
