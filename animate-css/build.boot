(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh info]]
         '[boot.task-helpers :as helpers])

(def +lib-version+ "3.5.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/animate-css
       :version     +version+
       :description "Just-add-water CSS animations"
       :url         "http://daneden.github.io/animate.css/"
       :scm         {:url "https://github.com/daneden/animate.css"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/daneden/animate.css/archive/master.zip")
             :unzip true)
   (sift :move {#"^animate.css-master/animate.css" "public/assets/animate.css"
                #"^animate.css-master/animate.min.css" "public/assets/animate.min.css"})

   (sift :include #{#"^public"})))
