(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.4.1")
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
              :checksum "0d7c96ba14179264c6739ddff3ac8471"
              :unzip true)
    (sift :move {#"^TinyColor.*/tinycolor\.js" "cljsjs/tinycolor/development/tinycolor.inc.js"
                 #"^TinyColor.*/dist/tinycolor-min\.js" "cljsjs/tinycolor/production/tinycolor.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.tinycolor")
    (pom)
    (jar)))
