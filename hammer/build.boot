(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "2.0.4-5")

(task-options!
 pom  {:project     'cljsjs/hammer
       :version     +version+
       :description "A javascript library for multi-touch gestures"
       :url         "http://hammerjs.github.io/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url "https://github.com/hammerjs/hammer.js/archive/2.0.4.zip"
              :checksum "F2A06997B5D731E86A114302D7838AA9"
              :unzip true)
    (sift :move {#"^hammer.js-\d\.\d\.\d/hammer.js"     "cljsjs/development/hammer.inc.js"
                 #"^hammer.js-\d\.\d\.\d/hammer.min.js" "cljsjs/production/hammer.min.inc.js"})
    (replace-content :in "cljsjs/production/hammer.min.inc.js" :match #"(?m)^//# sourceMappingURL=.*$" :value "")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.hammer")))
