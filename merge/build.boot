(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.2.0")
(def +version+ (str +lib-version+ "-0"))
(def +sha-short-version+ "6fc27c2")
(def +sha-version+ "6fc27c23e1ebf54a4f6ba8a7224dd48dfd9faf7c")

(task-options!
 pom  {:project     'cljsjs/merge
       :version     +version+
       :description "NodeJS Merge is used to merge multiple objects into one object."
       :url         "https://github.com/yeikos/js.merge"
       :scm         {:url "https://github.com/yeikos/js.merge"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://github.com/yeikos/js.merge/archive/%s.zip" +sha-short-version+)
             :checksum "0490dbdd0db39360895dc59dafb72f59"
             :unzip true)
   (sift :move {(re-pattern (str "^js\\.merge-" +sha-version+ "/merge\\.min\\.js$")) "cljsjs/merge/production/merge.min.inc.js"})
   (sift :move {(re-pattern (str "^js\\.merge-" +sha-version+ "/merge\\.js$")) "cljsjs/merge/development/merge.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.merge")
   (pom)
   (jar)))
