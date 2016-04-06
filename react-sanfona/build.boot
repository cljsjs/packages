(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]
                  [cljsjs/react       "0.13.3-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.0.4")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-sanfona
       :version     +version+
       :description "Accessible react accordion component"
       :url         "https://github.com/daviferreira/react-sanfona"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask download-react-sanfona []
  (download :url      (str "https://github.com/daviferreira/react-sanfona/archive/" +lib-version+ ".zip")
            :checksum "081d202e2e21a2cb555267bd86b40d3e"
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
