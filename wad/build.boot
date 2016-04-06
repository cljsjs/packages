(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.2.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/wad
       :version     +version+
       :description "Web Audio DAW. Use the HTML5 Web Audio API for dynamic sound synthesis."
       :url         "http://www.codecur.io/us/songdemo"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/rserota/wad/archive/" +lib-version+ ".zip")
              :checksum "8243AC4A291BCDB214094C0BA8BDA1B4"
              :unzip true)
    (sift :move {#"^wad-.*/build/wad.js" "cljsjs/development/wad.inc.js"
                 #"^wad-.*/build/wad.min.js" "cljsjs/production/wad.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.wad")
    (pom)
    (jar)))
