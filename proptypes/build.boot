(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[clojure.java.io :as io])

(def +lib-version+ "0.14.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/proptypes
       :version     +version+
       :description "React's PropTypes, as a standalone module"
       :url         "https://preactjs.com"
       :scm         {:url "https://github.com/developit/proptypes"}
       :license     {"BSD" "https://github.com/developit/proptypes/blob/master/LICENSE"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/developit/proptypes/archive/" +lib-version+ ".zip")
              :unzip true)
    (sift :move {#"proptypes-[^/]*/index\.js"      "cljsjs/proptypes/development/proptypes.inc.js"})
    (sift :include #{#"^cljsjs" #"^deps\.cljs"})
    (pom)
    (jar)))

