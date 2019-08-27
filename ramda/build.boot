(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.22.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/ramda
       :version     +version+
       :description "A practical functional library for Javascript programmers."
       :url         "http://ramdajs.com/"
       :scm         {:url "https://github.com/ramda/ramda"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download  :url      (format "https://github.com/ramda/ramda/archive/v0.22.1.zip" +lib-version+)
              :checksum "47F60C4BB10981A16A918006466A13F7"
              :unzip    true)
   (sift      :move     {#"^ramda(.*)/dist/ramda.js"
                         "cljsjs/ramda/development/ramda.inc.js"
                         #"^ramda(.*)/dist/ramda.min.js"
                         "cljsjs/ramda/production/ramda.min.inc.js"})
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.ramda")
   (pom)
   (jar)))
