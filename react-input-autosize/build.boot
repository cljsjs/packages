(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]
                  [cljsjs/react "0.14.3-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.6.5")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-input-autosize
       :version     +version+
       :description "Auto-resizing input field for React"
       :url         "http://jedwatson.github.io/react-input-autosize/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask package []
  (comp
    (download :url (str "https://github.com/JedWatson/react-input-autosize/archive/v" +lib-version+ ".zip")
	      :checksum "C4CEE37EB3F83923578893CD567F17F2"	
  	      :unzip true)

    (sift :move {#"^react-input-autosize.*[/ \\]dist[/ \\]react-input-autosize.js$" "cljsjs/react-input-autosize/development/react-input-autosize.inc.js"
	         #"^react-input-autosize.*[/ \\]dist[/ \\]react-input-autosize.min\.js$" "cljsjs/react-input-autosize/production/react-input-autosize.min.inc.js"})

    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-input-autosize"
               :requires ["cljsjs.react"])))
