(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]
                  [cljsjs/jquery    "1.9.1-0"] ])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "3.3.6-0")

(task-options!
  pom  {:project     'cljsjs/bootstrap
        :version     +version+
        :description "Javascript for Bootstap"
        :url         "http://getbootstrap.com"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url "https://github.com/twbs/bootstrap/releases/download/v3.3.6/bootstrap-3.3.6-dist.zip"
             :checksum "229936b042baadfc9f167244575ffe12"
             :unzip true)
   (sift :move {#"^bootstrap-([\d\.]*)-dist/js/bootstrap.js" "cljsjs/bootstrap/development/bootstrap.inc.js"
                #"^bootstrap-([\d\.]*)-dist/js/bootstrap.min.js" "cljsjs/bootstrap/production/bootstrap.min.inc.js"})
   (deps-cljs :name "cljsjs.bootstrap" :requires ["cljsjs.jquery"])
   (sift :include #{#"^cljsjs" #"^deps\.cljs$"})))
