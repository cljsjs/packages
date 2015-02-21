(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "1.9.0-0")

(task-options!
  pom  {:project     'cljsjs/jquery
        :version     +version+
        :description "The Write Less, Do More, JavaScript Library."
        :url         "http://jquery.com/"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url "http://code.jquery.com/jquery-1.9.0.js"
              :checksum "f3346149a7173e70d39e6f36bfb178a4")
    (download :url "http://code.jquery.com/jquery-1.9.0.min.js"
              :checksum "0652da382b6fceb033dfe2b6c06d4d11")
    (sift :move {#"jquery-([\d\.]*).js" "cljsjs/development/jquery.inc.js"
                 #"jquery-([\d\.]*).min.js" "cljsjs/production/jquery.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.jquery")))
