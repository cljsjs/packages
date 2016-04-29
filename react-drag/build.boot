(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]
                  [cljsjs/react "0.14.3-0"]
                  [cljsjs/react-dom "0.14.3-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.2.7")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-drag
       :version     +version+
       :description "Up to date fork of react-draggable"
       :url         "https://github.com/mgechev/react-drag"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask package []
  (comp
    (download :url "https://raw.githubusercontent.com/mgechev/react-drag/master/dist/react-drag.js"
	      :checksum "324BC46AB22AD0EF77DB783A4911CF57")
    (sift :move {#"^react-drag.js$" "cljsjs/react-drag/development/react-drag.inc.js"})

    (download :url "https://raw.githubusercontent.com/mgechev/react-drag/master/dist/react-drag.min.js"
	      :checksum "EBA187CC61A1ECEBED34E20C7A0647CC")
    (sift :move {#"^react-drag.min.js$" "cljsjs/react-drag/production/react-drag.min.inc.js"})

    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-drag"
               :requires ["cljsjs.react" 
			  "cljsjs.react.dom"])
    (pom)
    (jar)))
