(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                  [cljsjs/react "15.0.0-0"]
                  [cljsjs/react-dom "15.0.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.6")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-numeric-input
       :version     +version+
       :description "Numeric input component for react"
       :url         "https://github.com/vlad-ignatov/react-numeric-input"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask package []
  (comp
   (download :url (str "https://github.com/vlad-ignatov/react-numeric-input/archive/v" +lib-version+ ".zip")
             :checksum "8D0D60394A89861C2539D74661D72565"
             :unzip true)

   (sift :move {#"^react-numeric-input.*[/ \\]dist[/ \\]react-numeric-input.js$" "cljsjs/react-numeric-input/development/react-numeric-input.inc.js"
                #"^react-numeric-input.*[/ \\]dist[/ \\]react-numeric-input.min\.js$" "cljsjs/react-numeric-input/production/react-numeric-input.min.inc.js"})

   (sift :include #{#"^cljsjs"})

   (deps-cljs :name "cljsjs.react-numeric-input"
              :requires ["cljsjs.react"
                         "cljsjs.react.dom"])
   (pom)
   (jar)))
