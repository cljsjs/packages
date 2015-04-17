(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                 [cljsjs/boot-cljsjs "0.4.6"  :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.4.0-0")
(bootlaces! +version+)

(task-options!
 pom {:project     'cljsjs/showdown
      :version     +version+
      :description "A Markdown to HTML converter written in Javascript"
      :url         "https://github.com/showdownjs/showdown"
      :scm         {:url "https://github.com/showdownjs/showdown"}
      :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
   (download  :url      "https://github.com/showdownjs/showdown/archive/0.4.0.zip"
              :checksum "0fe8b927314a3e072ccb12d5e9de0319"
              :unzip    true)
   (sift      :move     {#"^showdown-(.*)/compressed/Showdown.js"
                         "cljsjs/showdown/development/showdown.inc.js"
                         #"^showdown-(.*)/compressed/Showdown.min.js"
                         "cljsjs/showdown/production/showdown.min.inc.js"})
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.showdown")))
