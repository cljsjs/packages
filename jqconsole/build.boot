(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[adzerk/bootlaces "0.1.12" :scope "test"]
                 [cljsjs/boot-cljsjs "0.5.0"  :scope "test"]
                 [cljsjs/jquery "2.1.4-0"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "2.13.1-0")

(defn ->site-version
  [boot-version]
  (str "v" (clojure.string/join "." (drop 1 (re-find #"(\d+)\.(\d+)\.(\d+)\-.*" boot-version)))))

(defn build-url
  [boot-version]
  (str "https://github.com/replit/jq-console/archive/" (->site-version boot-version) ".zip"))

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
   (download  :url      (build-url +version+)
              :unzip    true)
   (sift      :move     {#"^jq-console-(.*)/lib/jqconsole.js"
                         "cljsjs/jqconsole/development/jqconsole.inc.js"
                         #"^jq-console-(.*)/jqconsole.min.js"
                         "cljsjs/jqconsole/production/jqconsole.min.inc.js"
                         #"^jq-console-(.*)/css/ansi.css"
                         "cljsjs/jqconsole/common/css/ansi.css"})
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.jqconsole"
              :requires ["cljsjs.jquery"])))
