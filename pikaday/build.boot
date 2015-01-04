(set-env!
  :source-paths #{"pikaday"}
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces "0.1.8" :scope "test"]])
; Moment.js is optional dependency, if user has depended it directly or from other library
; it should be loaded before this.
; FIXME: How maven optional dependencies work?
; :dependencies '[[cljsjs/moment "2.8.4" :optional true]]

(require '[adzerk.bootlaces :refer :all])

(def +version+ "1.2.0")
(bootlaces! +version+)

(task-options!
  pom {:project 'cljsjs/pikaday
       :version +version+
       :description "A refreshing JavaScript Datepicker — lightweight, no dependencies, modular CSS"
       :url         "https://github.com/cljsjs/packages/tree/master/react"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {:name "Eclipse Public License"
                     :url  "http://www.eclipse.org/legal/epl-v10.html"}})

(deftask package []
  (comp
    (sift :move {#"pikaday\.js" "cljsjs/common/pikaday.inc.js"
                 #"css/pikaday\.css" "cljsjs/common/pikaday.css"})
    (sift :to-resource #{#"cljsjs/"})
    (build-jar)))
