(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]
                  [cljsjs/react "15.6.1-0"]
                  [cljsjs/react-dom "15.6.1-0"]
                  [cljsjs/moment "2.17.1-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.16.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-datetime
       :version     +version+
       :description "A lightweight but complete datetime picker react component."
       :url         "https://github.com/YouCanBookMe/react-datetime"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask download-datepicker []
  (download :url (str "https://github.com/YouCanBookMe/react-datetime/archive/" +lib-version+ ".zip")
            :unzip true))

(deftask package []
  (comp
    (download-datepicker)
    (sift :move {#"^react-datetime.*[/ \\]dist[/ \\]react-datetime.js$" "cljsjs/react-datetime/development/react-datetime.inc.js"
	         #"^react-datetime.*[/ \\]dist[/ \\]react-datetime.min\.js$" "cljsjs/react-datetime/production/react-datetime.min.inc.js"
	         #"^react-datetime.*[/ \\]css[/ \\]react-datetime.css$" "cljsjs/react-datetime/common/react-datetime.inc.css"})

    (sift :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.react-datetime"
               :requires ["cljsjs.react"
                          "cljsjs.react.dom"
                          "cljsjs.moment"])
    (pom)
    (jar)
    (validate-checksums)))
