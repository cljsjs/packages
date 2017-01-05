(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[boot.task-helpers]
         '[cljsjs.boot-cljsjs.packaging :refer :all])


(def +lib-version+ "0.1.0")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  push {:ensure-clean false}
  pom  {:project     'cljsjs/jsbn
        :version     +version+
        :description "Basic JavaScript BN library"
        :url         "http://www-cs-students.stanford.edu/~tjw/jsbn/jsbn.js"
        :license     {"BSD" "http://www-cs-students.stanford.edu/~tjw/jsbn/LICENSE"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask package []
  (comp
   (download :url "http://www-cs-students.stanford.edu/~tjw/jsbn/jsbn.js"
             :checksum "5E6FE0DA9EF45687E52781B9A646454E"
             :unzip false)

   (download :url "http://www-cs-students.stanford.edu/~tjw/jsbn/jsbn2.js"
             :checksum "402CB831E9747F7B0029CE06B8CD76BD"
             :unzip false)

   (sift :move {#"^jsbn.js" "cljsjs/jsbn/development/jsbn.inc.js"
                #"^jsbn.js" "cljsjs/jsbn/production/jsbn.min.inc.js"

                #"^jsbn2.js" "cljsjs/jsbn/development/jsbn2.inc.js"
                #"^jsbn2.js" "cljsjs/jsbn/production/jsbn2.min.inc.js"})

   (sift :include #{#"^cljsjs" #"^deps\.cljs"})

   (pom)
   (jar)))
