(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def juration-version "0.0.1")
(def +version+ (str juration-version "-0"))


(task-options!
 pom  {:project     'cljsjs/juration
       :version     +version+
       :description "Human friendly time duration parsing."
       :url         "https://github.com/domchristie/juration"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[clojure.java.io :as io])

(deftask package []
  (comp
    (download :url      "https://raw.githubusercontent.com/domchristie/juration/531b9d35a1e7af5a946f3da920b9d562bdca3fd2/juration.js"
              :name 	  "juration.js"
	            :unzip    false)
    (minify :in "juration.js"     :out "juration.min.js")
    (sift   :move {#"juration.js" "cljsjs/juration/development/juration.inc.js"
		               #"juration.min.js" "cljsjs/juration/production/juration.min.inc.js"})
    (sift   :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.juration")))
