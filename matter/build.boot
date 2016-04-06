(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.9.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project 'cljsjs/matter
      :version +version+
      :description "Matter.js is a JavaScript 2D rigid body physics engine for the web"
      :url "http://brm.io/matter-js/"
      :scm { :url "https://github.com/liabru/matter-js" }
      :license { "MIT" "https://github.com/liabru/matter-js/blob/master/LICENSE" }})

(deftask package []
  (comp
   (download :url (format "https://github.com/liabru/matter-js/archive/%s.zip" +lib-version+)
             :checksum "ab7cb444120723d1e5ce35bf52a15124"
             :unzip true)
   (sift :move {#"^.*/build/matter.js$" "cljsjs/matter/development/matter.inc.js"
                #"^.*/build/matter.min.js$" "cljsjs/matter/production/matter.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.matter")
   (pom)
   (jar)))
