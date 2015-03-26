(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.11" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.7" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "1.0.2-0")

(task-options!
  pom  {:project     'cljsjs/hashids
        :version     +version+
        :description "A small JavaScript class to generate YouTube-like hashids from one or many numbers. This is a client-side version of Node.js version."
        :url         "https://github.com/ivanakimov/hashids.js"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url "https://github.com/ivanakimov/hashids.js/archive/1.0.2.zip"
              :checksum "cafc7be2c2f901cc8fe2cc96292d35dc"
              :unzip true)
    (sift :move {#"^hashids.js-.*/lib/hashids.js" "cljsjs/development/hashids.inc.js"})
    (sift :move {#"^hashids.js-.*/lib/hashids.min.js" "cljsjs/production/hashids.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.hashids")))
