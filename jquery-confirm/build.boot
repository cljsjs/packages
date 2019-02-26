(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                  [cljsjs/jquery "1.12.4-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.3.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/jquery-confirm
       :version     +version+
       :description "A jQuery plugin that provides great set of features like, Auto-close, Ajax-loading, background-dismiss, themes and more."
       :url         "http://craftpip.github.io/jquery-confirm/"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/craftpip/jquery-confirm/releases/download/v" +lib-version+ "/jquery-confirm-v" +lib-version+ ".zip")
             :unzip true)
   (sift :move {#"jquery-confirm-master/css/jquery-confirm.css"      "cljsjs/jquery-confirm/development/jquery-confirm.inc.css"
                #"jquery-confirm-master/js/jquery-confirm.js"        "cljsjs/jquery-confirm/development/jquery-confirm.inc.js"
                #"jquery-confirm-master/dist/jquery-confirm.min.css" "cljsjs/jquery-confirm/production/jquery-confirm.min.inc.css"
                #"jquery-confirm-master/dist/jquery-confirm.min.js"  "cljsjs/jquery-confirm/production/jquery-confirm.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.jquery-confirm" :requires ["cljsjs.jquery"])
   (pom)
   (jar)
   (validate)))
