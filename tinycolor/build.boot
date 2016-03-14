(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.3.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/tinycolor
       :version     +version+
       :description "Fast Color Parsing and Manipulation."
       :url         "https://bgrins.github.io/TinyColor/"
       :scm         {:url "https://github.com/bgrins/TinyColor"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/bgrins/TinyColor/archive/%s.zip" +lib-version+)
              :checksum "37157cab313a15d4c26dbc9c205ad4a1"
              :unzip true)
    (sift :move {#"^TinyColor.*/tinycolor\.js" "cljsjs/tinycolor/development/tinycolor.inc.js"
                 #"^TinyColor.*/dist/tinycolor\.min\.js" "cljsjs/tinycolor/production/tinycolor.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.tinycolor")
    (pom)
    (jar)))
