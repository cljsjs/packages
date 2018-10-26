(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.3.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/disable-scroll
        :version     +version+
        :description "Prevent page scrolling"
        :url         "https://github.com/gilbarbara/disable-scroll"
        :license     {"MIT" "https://github.com/gilbarbara/disable-scroll/blob/master/LICENSE"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (format "https://github.com/gilbarbara/disable-scroll/archive/%s.zip" +lib-version+)
             :checksum "17758200DED2B46AB52A49AAF4DA439F"
             :unzip true)
   (sift :move {#"^disable-scroll-.*/dist/disable-scroll.js"  "cljsjs/disable-scroll/development/disable-scroll.inc.js"
                #"^disable-scroll-.*/dist/disable-scroll.min.js"  "cljsjs/disable-scroll/production/disable-scroll.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.disable-scroll")
   (pom)
   (jar)))
