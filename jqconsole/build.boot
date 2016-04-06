(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]
                 [cljsjs/jquery "2.1.4-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.13.2")
(def +version+ (str +lib-version+ "-0"))


(task-options!
 pom {:project     'cljsjs/jqconsole
      :version     +version+
      :description "A jQuery terminal plugin written in CoffeeScript"
      :url         "http://replit.github.com/jq-console/"
      :scm         {:url "https://github.com/replit/jq-console"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download  :url      (str "https://github.com/replit/jq-console/archive/v" +lib-version+ ".zip")
              :unzip    true)
   (sift      :move     {#"^jq-console-(.*)/lib/jqconsole.js"
                         "cljsjs/jqconsole/development/jqconsole.inc.js"
                         #"^jq-console-(.*)/jqconsole.min.js"
                         "cljsjs/jqconsole/production/jqconsole.min.inc.js"
                         #"^jq-console-(.*)/css/ansi.css"
                         "cljsjs/jqconsole/common/css/ansi.css"})
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.jqconsole"
              :requires ["cljsjs.jquery"])
   (pom)
   (jar)))
