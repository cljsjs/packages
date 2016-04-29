(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]
                  [cljsjs/jquery    "1.11.3-0"]
                  [cljsjs/moment    "2.10.6-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.0.8")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/jquery-daterange-picker
        :version     +version+
        :description "A jQuery plugin that allows user to select a date range."
        :url         "https://github.com/longbill/jquery-date-range-picker"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (format "https://github.com/longbill/jquery-date-range-picker/archive/%s.zip" +lib-version+)
             :checksum "4A0B00D958DB35378883E27D08E22B5D"
             :unzip true)
   (sift :move {#"^jquery-date-range-picker-[^\/]*/jquery\.daterangepicker\.js" "cljsjs/common/jquery-daterange-picker.inc.js"
                #"^jquery-date-range-picker-[^\/]*/daterangepicker\.css"        "cljsjs/common/jquery-daterange-picker.inc.css"})
   ; Not minifiable with asset-minifier. Should be fixed upstream and preferrably they should provide minifed version.
   ; (minify :in "cljsjs/development/jquery-daterange-picker.inc.js"
   ;         :out "cljsjs/production/jquery-daterange-picker.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.jquery-daterange-picker"
              :requires ["cljsjs.moment" "cljsjs.jquery"])
   (pom)
   (jar)))
