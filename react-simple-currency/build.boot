(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                  [cljsjs/react "15.0.0-0"]
                  [cljsjs/classnames "2.2.3-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.8")
(def +version+ (str +lib-version+ "-0"))
(def +checksum+ "0deb426843e651996fc8f40c0ab83d24")

(task-options!
 pom  {:project     'cljsjs/react-simple-currency
       :version     +version+
       :description "React Simple Currency is a wrapper that takes a value in cents and then masks it as currency."
       :url         "http://leonardowf.github.io/react-simple-currency"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask package []
  (comp
   (download :url (str "https://github.com/leonardowf/react-simple-currency/archive/v" +lib-version+ ".zip")
             :checksum +checksum+
             :unzip true)

   (sift :move {#"^react-simple-currency-.*[/ \\]dist[/ \\]react-simple-currency.js$" "cljsjs/react-simple-currency/development/react-simple-currency.inc.js"
                #"^react-simple-currency-.*[/ \\]dist[/ \\]react-simple-currency.min\.js$" "cljsjs/react-simple-currency/production/react-simple-currency.min.inc.js"})
   (sift :include #{#"^cljsjs"})

   (deps-cljs :name "cljsjs.react-simple-currency"
              :requires ["cljsjs.react"
                         "cljsjs.classnames"])
   (pom)
   (jar)))
