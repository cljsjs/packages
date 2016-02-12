(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]
                  [cljsjs/d3          "3.5.5-3"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.8.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/nvd3
       :version     +version+
       :description "A reusable chart library for d3.js"
       :url         "http://nvd3.org"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(defn cdn-url
  [file]
  (str "https://cdnjs.cloudflare.com/ajax/libs/nvd3/"
       +lib-version+ "/" file))

(deftask package []
  (comp
    (download :url (cdn-url "nv.d3.js"))
    (download :url (cdn-url "nv.d3.min.js"))
    (download :url (cdn-url "nv.d3.css"))
    (download :url (cdn-url "nv.d3.min.css"))
    (sift :move {#"nv.d3.js"       "cljsjs/nvd3/development/nvd3.inc.js"
                 #"nv.d3.min.js"   "cljsjs/nvd3/production/nvd3.min.inc.js"
                 #"nv.d3.css"      "cljsjs/nvd3/common/nvd3.css"
                 #"nv.d3.min.css"  "cljsjs/nvd3/common/nvd3.min.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.nvd3"
               :requires ["cljsjs.d3"])))
