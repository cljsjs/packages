(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "2.1.3")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/classnames
       :version     +version+
       :description "A simple javascript utility for conditionally joining classNames together"
       :url         "https://github.com/JedWatson/classnames"
       :scm         {:url "https://github.com/JedWatson/classnames"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/JedWatson/classnames/archive/v" +version+ ".zip")
              :checksum "f0643b8b2571a110aa2c8767fbba2b16" 
              :unzip    true)
    (sift     :move     {(re-pattern (str "^classnames-" +version+ "/index.js"))
                         "cljsjs/development/classnames.inc.js"})
    (minify   :in       "cljsjs/development/classnames.inc.js"
              :out      "cljsjs/production/classnames.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.classnames")))
