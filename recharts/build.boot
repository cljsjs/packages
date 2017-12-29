(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.0" :scope "test"]
                 [cljsjs/react "15.6.2-4"]
                 [cljsjs/react-transition-group "2.2.0-0"]
                 [cljsjs/react-dom "15.6.2-4"]
                 [cljsjs/prop-types "15.6.0-0"]])

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.0-alpha.4")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/recharts
       :version     +version+
       :description "Redefined chart library built with React and D3"
       :url         "http://recharts.org"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://raw.githubusercontent.com/react-bootstrap/react-bootstrap/master/LICENSE"}})

(deftask package []
  (comp
   (download :url (str "https://unpkg.com/recharts@" +lib-version+ "/umd/Recharts.js")
             :unzip false)
   (download :url (str "https://unpkg.com/recharts@" +lib-version+ "/umd/Recharts.min.js")
             :unzip false)
   (sift :move {#"Recharts\.js" "cljsjs/recharts/development/Recharts.inc.js"
                #"Recharts\.min\.js" "cljsjs/recharts/production/Recharts.min.inc.js"})
   (deps-cljs :name "cljsjs.recharts"
              :requires ["cljsjs.react" "cljsjs.prop-types"])
   (sift :include #{#"^cljsjs" #"^deps\.cljs$"})
   (pom)
   (jar)
   (validate-checksums)))
