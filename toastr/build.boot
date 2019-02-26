(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                  [cljsjs/jquery    "2.2.2-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.1.2")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  pom  {:project     'cljsjs/toastr
        :version     +version+
        :description "A Javascript library for Gnome / Growl type non-blocking notifications."
        :url         "https://github.com/CodeSeven/toastr"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/CodeSeven/toastr/archive/" +lib-version+ ".zip")
             :unzip true)
   (sift :move {#"^toastr-([\d\.]*)/toastr.js"            "cljsjs/toastr/development/toastr.inc.js"
                #"^toastr-([\d\.]*)/build/toastr.css"     "cljsjs/toastr/development/toastr.inc.css"
                #"^toastr-([\d\.]*)/build/toastr.min.css" "cljsjs/toastr/production/toastr.min.inc.css"
                #"^toastr-([\d\.]*)/build/toastr.min.js"  "cljsjs/toastr/production/toastr.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.toastr"
              :requires ["cljsjs.jquery"])
   (pom)
   (jar)
   (validate)))
