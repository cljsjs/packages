(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                  [cljsjs/react "15.3.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.1.4")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-vis-force
       :version     +version+
       :description "react-vis-force applies the react-vis and d4-style component approach to the d3-force library."
       :url         "https://github.com/uber/react-vis-force"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "https://opensource.org/licenses/BSD-3-Clause"}})

(require '[clojure.java.io :as io])

(deftask package []
  (comp
    (download :url (str "https://unpkg.com/react-vis-force@" +lib-version+ "/dist/react-vis-force.js")
              :checksum "5860feef46d67e9b73a3171c0ea51294")
    (download :url (str "https://unpkg.com/react-vis-force@" +lib-version+ "/dist/react-vis-force.min.js")
              :checksum "b7fbfc6ecbabef2dc68c995c040f1c80")
    (download :url (str "https://unpkg.com/react-vis-force@" +lib-version+ "/dist/react-vis-force.css")
              :checksum "b31bc638d72882cdb070d330bd045d96")
    (sift :move {#"^react-vis-force.js"      "cljsjs/react-vis-force/development/react-vis-force.inc.js"
                 #"^react-vis-force.min.js"  "cljsjs/react-vis-force/development/react-vis-force.min.inc.js"
                 #"^react-vis-force.css"     "cljsjs/react-vis-force/development/react-vis-force.min.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-vis-force"
               :requires ["cljsjs.react"])
    (pom)
    (jar)))
