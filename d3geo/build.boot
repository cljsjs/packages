(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]
                  [cljsjs/d3 "3.5.7-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.2.15")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/d3geo
       :version     +version+
       :description "Extended Projections for D3.js"
       :url         "https://github.com/mbostock/d3/wiki/Geo-Projections"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/d3/d3-geo-projections/archive/v" +lib-version+ ".zip")
              :checksum "c95010114cc806fdfee681e85711042a"
              :unzip true)
    (sift :move {#"^d3-geo-projection-([\d\.]*)/d3\.geo\.projection\.js"      "cljsjs/d3geo/development/d3geo.inc.js"
                 #"^d3-geo-projection-([\d\.]*)/d3\.geo\.projection\.min\.js" "cljsjs/d3geo/production/d3geo.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.d3geo"
               :requires ["cljsjs.d3"])))
