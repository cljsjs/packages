(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.10.3-0")

(task-options!
 pom  {:project     'cljsjs/dropbox
       :version     +version+
       :description "Javascript client for Dropbox"
       :url         "https://github.com/dropbox/dropbox-js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Dropbox ToS" "https://www.dropbox.com/terms"}})

(deftask package []
  (comp
   (download :url "http://cdnjs.cloudflare.com/ajax/libs/dropbox.js/0.10.3/dropbox.js")
   (download :url "http://cdnjs.cloudflare.com/ajax/libs/dropbox.js/0.10.3/dropbox.min.js")
   (sift :move {#"^dropbox\.js" "cljsjs/dropbox/development/dropbox.inc.js"
                #"^dropbox\.min\.js" "cljsjs/dropbox/production/dropbox.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.dropbox")))
