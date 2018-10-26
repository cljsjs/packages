(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.6.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/soundjs
      :version     +version+
      :description "A Javascript library for working with Audio."
      :url         "http://www.createjs.com/soundjs"
      :scm         {:url "https://github.com/CreateJS/SoundJS"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download  :url      (format "https://github.com/CreateJS/SoundJS/releases/download/%s/soundjs-%s.combined.js" +lib-version+ +lib-version+)
              :checksum "C487343F1D23259D6D82C0B564FBB174")
   (download  :url      (format "https://github.com/CreateJS/SoundJS/releases/download/%s/soundjs-%s.min.js" +lib-version+ +lib-version+)
              :checksum "4C1425CE52FF873D9FB7AA4DAF23B94D")
   (sift      :move     {#"^soundjs-.*combined.js"
                         "cljsjs/soundjs/development/soundjs.inc.js"
                         #"^soundjs-.*min.js"
                         "cljsjs/soundjs/production/soundjs.min.inc.js"})
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.soundjs")
   (pom)
   (jar)))
