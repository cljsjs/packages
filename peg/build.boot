(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6"  :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.8.0-0")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/peg
       :version     +version+
       :description "PEG.js: Parser generator for JavaScript"
       :url         "http://pegjs.org/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
    (download :url "https://github.com/pegjs/pegjs/releases/download/v0.8.0/peg-0.8.0.js"
              :checksum "992f208961e69128046411f881776c5f")
    (download :url "https://github.com/pegjs/pegjs/releases/download/v0.8.0/peg-0.8.0.min.js"
              :checksum "abd4f4b562bcc818b5ef842c756f386e")
    (sift :move {#"^peg-0\.8\.0\.js"      "cljsjs/peg/development/peg.inc.js"
                 #"^peg-0\.8\.0\.min\.js" "cljsjs/peg/production/peg.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.peg")))
