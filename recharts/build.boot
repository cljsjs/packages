(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                 [cljsjs/react "17.0.1-0"]
                 [cljsjs/react-dom "17.0.1-0"]
                 [cljsjs/prop-types "15.6.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.8")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/recharts
       :version     +version+
       :description "A composable charting library built on React components"
       :url         "http://recharts.org"
       :scm         {:url "https://github.com/recharts/recharts"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/recharts@%s/umd/Recharts.js" +lib-version+)
             :target "cljsjs/recharts/development/recharts.inc.js")
   (download :url (format "https://unpkg.com/recharts@%s/umd/Recharts.min.js" +lib-version+)
             :target "cljsjs/recharts/production/recharts.min.inc.js")
   (deps-cljs :provides ["recharts" "cljsjs.recharts"]
              :requires ["react" "react-dom" "prop-types"]
              :global-exports '{recharts Recharts})
   (sift :include #{#"^cljsjs" #"^deps\.cljs$"})
   (pom)
   (jar)
   (validate)))
