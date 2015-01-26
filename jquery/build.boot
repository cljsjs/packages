(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.1" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "1.8.2-2")

(task-options!
  pom  {:project     'cljsjs/jquery
        :version     +version+
        :description "The Write Less, Do More, JavaScript Library."
        :url         "http://jquery.com/"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url "http://code.jquery.com/jquery-1.8.2.js"
              :checksum "3a316818411b5a80ef878dc5c8483950")
    (download :url "http://code.jquery.com/jquery-1.8.2.min.js"
              :checksum "0b6ecf17e30037994d3ffee51b525914")
    (sift :move {#"jquery-([\d\.]*).js" "cljsjs/development/jquery.inc.js"
                 #"jquery-([\d\.]*).min.js" "cljsjs/production/jquery.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.jquery")))
