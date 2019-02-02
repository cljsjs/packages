(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(def +lib-version+ "10.0.6")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/emotion
      :version     +version+
      :description "CSS-in-JS library designed for high performance style composition"
      :scm         {:url "https://github.com/emotion-js/emotion"}
      :url         "https://emotion.sh"})

(deftask package []
  (comp
   (download :url  (format "https://unpkg.com/emotion@%s/dist/emotion.umd.min.js" +lib-version+))
   (sift :move {#"emotion.umd.min.js" "cljsjs/development/emotion.inc.js"})
   (download :url  (format "https://unpkg.com/emotion@%s/dist/emotion.umd.min.js" +lib-version+))
   (sift :move {#"emotion.umd.min.js" "cljsjs/development/emotion.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.emotion"
              :requires [])
   (pom)
   (jar)))