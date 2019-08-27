(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.2.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/shake
      :version     +version+
      :description "A custom 'shake' event plugin for mobile web browsers using device accelerometer."
      :url         "https://github.com/alexgibson/shake.js"
      :scm         {:url "https://github.com/alexgibson/shake.js"}
      :license     {"MIT" "https://github.com/alexgibson/shake.js/blob/v1.2.2/LICENSE.md"}})

(deftask package []
  (comp
   (download  :url      (format "https://github.com/alexgibson/shake.js/archive/v%s.zip" +lib-version+)
              :checksum "2037124bbcb80dfe25167e7d3281ea50"
              :unzip    true)
   (sift      :move     {#"^shake\.js-.+/shake\.js$" "cljsjs/shake/development/shake.inc.js"})
   (minify    :in       "cljsjs/shake/development/shake.inc.js"
              :out      "cljsjs/shake/production/shake.min.inc.js")
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.shake")
   (pom)
   (jar)))
