(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "1.9.1-0")

(task-options!
  pom  {:project     'cljsjs/jquery
        :version     +version+
        :description "The Write Less, Do More, JavaScript Library."
        :url         "http://jquery.com/"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url "http://code.jquery.com/jquery-1.9.1.js"
              :checksum "08C235D357750C657AC1DB7D1CF656A9")
    (download :url "http://code.jquery.com/jquery-1.9.1.min.js"
              :checksum "397754BA49E9E0CF4E7C190DA78DDA05")
    (sift :move {#"jquery-([\d\.]*).js" "cljsjs/development/jquery.inc.js"
                 #"jquery-([\d\.]*).min.js" "cljsjs/production/jquery.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.jquery")))
