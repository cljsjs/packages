(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "2.1.1-0")

(task-options!
  pom  {:project     'cljsjs/jquery
        :version     +version+
        :description "The Write Less, Do More, JavaScript Library."
        :url         "http://jquery.com/"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url "http://code.jquery.com/jquery-2.1.1.js"
              :checksum "7403060950F4A13BE3B3DFDE0490EE05")
    (download :url "http://code.jquery.com/jquery-2.1.1.min.js"
              :checksum "E40EC2161FE7993196F23C8A07346306")
    (sift :move {#"jquery-([\d\.]*).js" "cljsjs/development/jquery.inc.js"
                 #"jquery-([\d\.]*).min.js" "cljsjs/production/jquery.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.jquery")))
