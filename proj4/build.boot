(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.5.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/proj4
       :version     +version+
       :description "JavaScript library to transform coordinates from one coordinate system to another, including datum transformations"
       :url         "http://proj4js.org/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (format "https://unpkg.com/proj4@%s/dist/proj4.js" +lib-version+)
              :target "cljsjs/proj4/development/proj4.inc.js")

    (download :url (format "https://unpkg.com/proj4@%s/dist/proj4-src.js" +lib-version+)
              :target "cljsjs/proj4/production/proj4.min.inc.js")

    (deps-cljs :provides ["proj4" "cljsjs.proj4"]
               :global-exports '{proj4 proj4})
    (pom)
    (jar)))
