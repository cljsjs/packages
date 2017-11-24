(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.9.0"  :scope "test"]
                  [cljsjs/react "15.6.1-1"]
                  [cljsjs/react-dom-server "15.6.1-1"]
                  [cljsjs/react-dom "15.6.1-1"]
                  [cljsjs/prop-types "15.5.10-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.12.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-infinite
       :version     +version+
       :description "A browser-ready efficient scrolling container based on UITableView."
       :url         "https://github.com/seatgeek/react-infinite"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/seatgeek/react-infinite/archive/v" +lib-version+ ".zip")
             :checksum "3c9e2b831e996b59a19b560be5e9f77a"
             :unzip true)

   (sift :move {#"^react-infinite-(.*)/dist/react-infinite.js$" "cljsjs/react-infinite/development/react-infinite.inc.js"
                #"^react-infinite-(.*)/dist/react-infinite.min.js$" "cljsjs/react-infinite/production/react-infinite.min.inc.js"})

   (sift :include #{#"^cljsjs"})

   (deps-cljs :name "react-infinite"
              :requires ["react" "react-dom" "prop-types"])
   (pom)

   (jar)))
