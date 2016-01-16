(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

; FIXME: Next version should use real version number
(def +lib-version+ "0.8.0")
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
   ; FIXME: Next version should use +lib-version+
   (download :url (format "https://github.com/liabru/matter-js/archive/%s.zip" (str +lib-version+ "-alpha"))
             :checksum "731D6C790A8CBF3EA55B1F1131C5A761"
             :unzip true)
   (sift :move {#"^.*/build/matter.js$" "cljsjs/matter/development/matter.inc.js"
                #"^.*/build/matter.min.js$" "cljsjs/matter/production/matter.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.matter")))
