(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]
                  ])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.1.0")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/llexus-validate
       :version     +version+
       :description "A simple validator for a subset of JSON-Schema."
       :url         "https://github.com/little-arhat/llexus-validate"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/little-arhat/llexus-validate/archive/%s.zip" +lib-version+)
              :checksum "5d16a0e3a75bb552c498d67c6a40213d"
              :unzip true)
    (sift :move {#"^llexus-validate-([\d\.-]*)/dist/llexus-validate\.js"      "cljsjs/llexus-validate/development/llexus-validate.inc.js"
                 #"^llexus-validate-([\d\.-]*)/dist/llexus-validate\.min\.js" "cljsjs/llexus-validate/production/llexus-validate.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.llexus-validate")))
