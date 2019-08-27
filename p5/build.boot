(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.9.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project 'cljsjs/p5
      :version +version+
      :description "p5.js is a JS client-side library for creating graphic and interactive experiences, based on the core principles of Processing"
      :url "https://p5js.org/"
      :scm { :url "https://github.com/processing/p5.js" }
      :license { "LGPL" "https://github.com/processing/p5.js/blob/master/license.txt" }})

(deftask package []
  (comp
   (download :url (format "https://github.com/processing/p5.js/releases/download/%s/p5.zip" +lib-version+)
             :unzip true)
   (sift :move {#"^.*/p5.min.js$" "cljsjs/p5/production/p5.min.inc.js"
                #"^.*/p5.js$" "cljsjs/p5/development/p5.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.p5")
   (pom)
   (jar)
   (validate)))
