(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.6.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/opentype
       :version     +version+
       :description "Read and write OpenType fonts using JavaScript."
       :url         "http://opentype.js.org//"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/nodebox/opentype.js/archive/" +lib-version+ ".zip")
              :checksum "CA2C9DC109BF1AB20F17B1E6F012C0E4"
              :unzip true)
    (sift :move {#"^opentype.js-([\d\.]*)/dist/opentype\.js"      "cljsjs/opentype/development/opentype.inc.js"
                 #"^opentype.js-([\d\.]*)/dist/opentype\.min\.js" "cljsjs/opentype/production/opentype.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.opentype")))
