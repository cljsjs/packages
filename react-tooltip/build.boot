(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]
                  [cljsjs/react "15.3.1-0"]
                  [cljsjs/react-dom "15.3.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.3.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-tooltip
       :version     +version+
       :description "react tooltip component"
       :url         "https://github.com/wwayne/react-tooltip/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask download-react-tooltip []
  (download :url (format "https://github.com/wwayne/react-tooltip/archive/%s.zip" +lib-version+)
              :checksum "16a6dc218c26658447b1a69175c9de62"
              :unzip true))


(deftask package []
  (comp
    
    (download-react-tooltip)

    (sift :move {#"^react-tooltip-.*/standalone/react-tooltip.js" "cljsjs/react-tooltip/development/react-tooltip.inc.js"})

    (sift :move {#"^react-tooltip-.*/standalone/react-tooltip.min.js" "cljsjs/react-tooltip/production/react-tooltip.min.inc.js"})

    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-tooltip"
               :requires ["cljsjs.react" "cljsjs.react.dom"])
    (pom)
    (jar)))
