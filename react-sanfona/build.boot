(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2"  :scope "test"]
                  [cljsjs/react       "15.3.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.0.14")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-sanfona
       :version     +version+
       :description "Accessible react accordion component"
       :url         "https://github.com/daviferreira/react-sanfona"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask download-react-sanfona []
  (download :url      (str "https://github.com/daviferreira/react-sanfona/archive/v" +lib-version+ ".zip")
            :checksum "536bf3f4a7d504c99fd14f74e77122a1"
            :unzip    true))

(deftask package []
  (comp
    (download-react-sanfona)
    (minify :in (str "react-sanfona-" +lib-version+ "/dist/react-sanfona.js")
            :out (str "react-sanfona-" +lib-version+ "/dist/react-sanfona.min.js"))
    (sift :move {#"^react-.*/dist/react-sanfona.js"
                 "cljsjs/react-sanfona/development/react-sanfona.inc.js"
                 #"^react-.*/dist/react-sanfona.min.js"
                 "cljsjs/react-sanfona/production/react-sanfona.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-sanfona"
               :requires ["cljsjs.react"])
    (pom)
    (jar)))
