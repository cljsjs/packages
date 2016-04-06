(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]
		  [cljsjs/react "0.14.3-0"]
                  [cljsjs/moment "2.10.6-0"]
                  [cljsjs/tether "1.1.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.15.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-datepicker
       :version     +version+
       :description "A simple and reusable datepicker component for React"
       :url         "http://hacker0x01.github.io/react-datepicker"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask package []
  (comp
    (download :url (str "https://github.com/Hacker0x01/react-datepicker/archive/v" +lib-version+ ".zip")
	      :checksum "B5BCCD5BB8A0C01A93FD31C32BBF1BE2"	
              :unzip true)

    (sift :move {#"^react-datepicker.*[/ \\]dist[/ \\]react-datepicker.js$" "cljsjs/react-datepicker/development/react-datepicker.inc.js"
	         #"^react-datepicker.*[/ \\]dist[/ \\]react-datepicker.min\.js$" "cljsjs/react-datepicker/production/react-datepicker.min.inc.js"
	         #"^react-datepicker.*[/ \\]dist[/ \\]react-datepicker.css$" "cljsjs/react-datepicker/common/react-datepicker.inc.css"})

    (sift :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.react-datepicker"
               :requires ["cljsjs.react"
                          "cljsjs.moment"
			  "cljsjs.tether"])
    (pom)
    (jar)))
