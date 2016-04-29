(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.1"  :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "1.2.7-0")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/tv4
       :version     +version+
       :description "Tiny Validator for v4 JSON Schema"
       :url         "http://geraintluff.github.io/tv4/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/mit-license.php"}})

(deftask package []
  (comp
    (download :url "https://github.com/geraintluff/tv4/archive/v1.2.7.zip"
              :unzip true)
    (sift :move {#"^tv4-([\d\.]*)/tv4\.js"      "cljsjs/tv4/development/tv4.inc.js"
                 #"^tv4-([\d\.]*)/tv4\.min\.js" "cljsjs/tv4/production/tv4.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.tv4")
    (pom)
    (jar)))
