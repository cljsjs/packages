(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]
                  [cljsjs/jquery    "2.2.2-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.1.2")
(def +version+ (str +lib-version+ "-0"))

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
             :checksum "2B34F3F8D481170EF8CAB45F3A90F1E6"
             :unzip true)
    (sift :move {#"^toastr-([\d\.]*)[\/\\]toastr.js" "cljsjs/development/toastr.inc.js"
                 #"^toastr-([\d\.]*)[\/\\]build[\/\\]toastr.min.js" "cljsjs/production/toastr.min.inc.js"
                 #"^toastr-([\d\.]*)[\/\\]build[\/\\]toastr.css" "cljsjs/common/toastr.css"
				 #"^toastr-([\d\.]*)[\/\\]build[\/\\]toastr.min.css" "cljsjs/common/toastr.min.css"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.toastr"
              :requires ["cljsjs.jquery"])
   (pom)
   (jar)))