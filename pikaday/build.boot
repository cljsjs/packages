(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.8" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.0" :scope "test"]])
; Moment.js is optional dependency, if user has depended it directly or from other library
; it should be loaded before this.
; FIXME: How maven optional dependencies work?
; :dependencies '[[cljsjs/moment "2.8.4" :optional true]]

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "1.2.0-1")
(bootlaces! +version+)

(task-options!
  pom {:project 'cljsjs/pikaday
       :version +version+
       :description "A refreshing JavaScript Datepicker - lightweight, no dependencies, modular CSS"
       :url         "https://github.com/dbushell/Pikaday"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {:name "MIT & BSD" :url "https://raw.githubusercontent.com/dbushell/Pikaday/master/LICENSE"}})

(deftask package []
  (comp
    (download :url "https://github.com/dbushell/Pikaday/archive/1.2.0.zip"
              :checksum "ee076ed672c366bcc96f899c1c0e499b"
              :unzip true)
    (sift :move {#"^Pikaday.*/pikaday\.js" "cljsjs/common/pikaday.inc.js"
                 #"^Pikaday.*/css/pikaday\.css" "cljsjs/common/pikaday.css"})
    (sift :include #{#"^cljsjs/"})
    (build-jar)))
