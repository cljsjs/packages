(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.8.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/echarts
       :version     +version+
       :description "A powerful, interactive charting and visualization library for browser"
       :url         "https://github.com/apache/incubator-echarts"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache-2.0" "https://github.com/apache/incubator-echarts/blob/master/LICENSE"}})

(defn cdn-ver [file]
  (str "https://unpkg.com/echarts@"
       +lib-version+ "/dist/" file))

(deftask package []
  (comp
   (download :url (cdn-ver "echarts-en.js"))
   (download :url (cdn-ver "echarts-en.min.js"))
   (sift :move {#"echarts-en.js" "cljsjs/echarts/development/echarts.inc.js"
                #"echarts-en.min.js" "cljsjs/echarts/production/echarts.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.echarts")
   (pom)
   (jar)
   (validate-checksums)))
