(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.11" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0"  :scope "test"]
                  [cljsjs/moment "2.6.0-3"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "1.4.0-0")
(bootlaces! +version+)

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
    (download :url "https://github.com/dbushell/Pikaday/archive/1.4.0.zip"
              :checksum "12766879AC4E23CE71768FE8A706C4A7"
              :unzip true)
    (sift :move {#"^Pikaday.*/pikaday\.js" "cljsjs/common/pikaday.inc.js"
                 #"^Pikaday.*/scss/pikaday\.scss" "cljsjs/common/pikaday.scss"
                 #"^Pikaday.*/css/pikaday\.css" "cljsjs/common/pikaday.css"})
    (sift :include #{#"^cljsjs/" #"^deps.cljs$"})))
