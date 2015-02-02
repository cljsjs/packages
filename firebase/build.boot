(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "2.1.2-1")

(task-options!
 pom  {:project     'cljsjs/firebase
       :version     +version+
       :description "Firebase.js packaged up with Google Closure externs"
       :url         "https://www.firebase.com/docs/web/api/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Firebase ToS" "https://www.firebase.com/terms/terms-of-service.html"}})

(deftask package []
  (comp
    (download :url "https://github.com/firebase/firebase-bower/archive/v2.1.2.zip"
              :checksum "87102b3ccd1946badc44c896036b08a9"
              :unzip true)
    (sift :move {#"firebase-bower-([\d\.]*)/firebase.js" "cljsjs/development/firebase.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.firebase")))
