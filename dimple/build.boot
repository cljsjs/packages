(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]
                  [cljsjs/d3 "3.5.5-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.1.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/dimple
       :version     +version+
       :description "A JavaScript charting library based on d3"
       :url         "http://dimplejs.org/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://raw.githubusercontent.com/PMSI-AlignAlytics/dimple/" +lib-version+ "/dist/dimple.v" +lib-version+ ".js")
             :checksum "FD30B182DBF07FF8EF314CB1C734DC82")
   (download :url "https://raw.githubusercontent.com/PMSI-AlignAlytics/dimple/" +lib-version+ "/dist/dimple.v" +lib-version+ ".min.js"
             :checksum "C5D7EF47BA2445A130A00F3A9ABC1B78")
   (sift :move {#"^dimple\.v([\d+\.]*).js" "cljsjs/dimple/development/dimple.inc.js"
                #"^dimple\.v([\d+\.]*).min.js" "cljsjs/dimple/production/dimple.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.dimple"
              :requires ["cljsjs.d3"])
   (pom)
   (jar)))
