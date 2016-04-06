(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]
                  [cljsjs/jquery    "1.8.2-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.8.10")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/jquery-timepicker
        :version     +version+
        :description "A Javascript timepicker plugin for jQuery inspired by Google Calendar"
        :url         "https://github.com/jonthornton/jquery-timepicker"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (format "https://github.com/jonthornton/jquery-timepicker/archive/%s.zip" +lib-version+)
             :checksum "6D6900D16B735594CC56BA6BDA8597C5"
             :unzip true)
    (sift :move {#"^jquery-timepicker-[^\/]*/jquery\.timepicker\.js" "cljsjs/common/jquery-timepicker.inc.js"
                 #"^jquery-timepicker-[^\/]*/jquery\.timepicker\.min.js" "cljsjs/common/jquery-timepicker.min.inc.js"
                 #"^jquery-timepicker-[^\/]*/jquery.timepicker\.css"        "cljsjs/common/jquery-timepicker.inc.css"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.jquery-timepicker"
              :requires ["cljsjs.jquery"])
   (pom)
   (jar)))
