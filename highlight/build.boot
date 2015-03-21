(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.11" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.7" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def highlight-version "8.4.0")
(def +version+ (str highlight-version "-0"))
(bootlaces! +version+)

(task-options!
  pom {:project     'cljsjs/highlight
       :version     +version+
       :description "highlight"
       :url         "https://highlightjs.org/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "https://github.com/isagalaev/highlight.js/blob/master/LICENSE"}})

(deftask package []
  (task-options! push {:ensure-branch nil})
  (comp
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.highlight")))
