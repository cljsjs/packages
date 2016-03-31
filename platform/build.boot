(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[boot.task-helpers]
         '[cljsjs.boot-cljsjs.packaging :refer :all])


(def +lib-version+ "1.0.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  push {:ensure-clean false}
  pom  {:project     'cljsjs/platform
        :version     +version+
        :description "Authenticate with Google API"
        :url         "https://apis.google.com/js/platform.js"
        :license     {"MIT" "https://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask package []
  (comp
   (download :url (format "https://apis.google.com/js/platform.js")
             :checksum "e6771ebfb2ba29448405372e3de8da27"
             :unzip false)


   (sift :move {#"platform.js"  "cljsjs/platform/development/platform.inc.js"
                #"platform.js"  "cljsjs/platform/production/platform.inc.js"})

   (sift :include #{#"^cljsjs"})

   (deps-cljs :name "cljsjs.platform")
   (pom)
   (jar)))
