(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[adzerk/bootlaces "0.1.12" :scope "test"]
                 [cljsjs/boot-cljsjs "0.5.0"  :scope "test"]
                 [cljsjs/jquery "1.9.1-0"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "2.12.0-0")
(bootlaces! +version+)

(task-options!
 pom {:project     'cljsjs/jqconsole
      :version     +version+
      :description "A jQuery terminal plugin written in CoffeeScript"
      :url         "http://replit.github.com/jq-console/"
      :scm         {:url "https://github.com/replit/jq-console"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download  :url      "https://github.com/replit/jq-console/zipball/master"
              :unzip    true)
   (sift      :move     {#"^replit-jq-console-(.*)/lib/jqconsole.js"
                         "cljsjs/jqconsole/development/jqconsole.inc.js"
                         #"^replit-jq-console-(.*)/jqconsole.min.js"
                         "cljsjs/jqconsole/production/jqconsole.min.inc.js"
                         #"^replit-jq-console-(.*)/css/ansi.css"
                         "cljsjs/jqconsole/common/css/ansi.css"})
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.jqconsole"
              :requires ["cljsjs.jquery"])))
