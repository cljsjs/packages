(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "2.2.7-0")

(task-options!
 pom  {:project     'cljsjs/firebase
       :version     +version+
       :description "Javascript client for Firebase.com"
       :url         "https://www.firebase.com/docs/web/api/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Firebase ToS" "https://www.firebase.com/terms/terms-of-service.html"}})

(deftask package []
  (comp
    (download :url "https://github.com/firebase/firebase-bower/archive/v2.2.7.zip"
              :checksum "4BA3685E136567A0BA1F63AE446914A2"
              :unzip true)
    (sift :move {#"firebase-bower-([\d\.]*)/firebase.js" "cljsjs/development/firebase.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.firebase")))
