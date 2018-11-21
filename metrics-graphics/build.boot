(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]
                  [cljsjs/d3 "4.2.2-0"]
                  [cljsjs/jquery "2.2.4-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.10.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/metrics-graphics
        :version     +version+
        :description "A library optimized for concise and principled data graphics and layouts."
        :url         "http://metricsgraphicsjs.org/"
        :scm         {:url "https://github.com/cljsjs/packages"}
        :license     {"Mozilla Public License, version 2.0" "https://github.com/mozilla/metrics-graphics/blob/master/LICENSE"}})

(deftask package []
         (comp
           (download :url (str "https://github.com/mozilla/metrics-graphics/archive/v" +lib-version+ ".zip")
                     :checksum "3626993026b3398021018b4617b36a00"
                     :unzip true)
           (sift :move {#"^metrics-graphics-([\d\.]*)/dist/metricsgraphics\.js"      "cljsjs/metrics-graphics/development/metricsgraphics.inc.js"
                        #"^metrics-graphics-([\d\.]*)/dist/metricsgraphics\.min\.js" "cljsjs/metrics-graphics/production/metricsgraphics.min.inc.js"
                        #"^metrics-graphics-([\d\.]*)/dist/metricsgraphics\.css" "cljsjs/metrics-graphics/common/metricsgraphics.inc.css"})
           (sift :include #{#"^cljsjs"})
           (deps-cljs :name "cljsjs.metrics-graphics"
                      :requires ["cljsjs.d3"
                                 "cljsjs.jquery"])
           (pom)
           (jar)))
