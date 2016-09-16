(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.2"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.2.6")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/highstock
       :version     +version+
       :description "Highstock lets you create stock or general timeline charts in pure JavaScript."
       :url         "http://highcharts.com/products/highstock"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"CC BY-NC" "http://creativecommons.org/licenses/by-nc/3.0/"}})

(deftask package []
  (comp
   (download :url (str "https://code.highcharts.com/stock/" +lib-version+ "/highstock.js")
             :checksum "DCEDC903E6956F8766A9543524816331")
   (download :url (str "https://code.highcharts.com/stock/" +lib-version+ "/highstock.src.js")
             :checksum "0AFAC63726D0E216BEF5FA56E3F98717")
   (sift :move {#"highstock.js"     "cljsjs/production/highstock.min.inc.js"})
   (sift :move {#"highstock.src.js" "cljsjs/development/highstock.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.highstock")
   (pom)
   (jar)))
