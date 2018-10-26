
(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "8.2.5")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/preact
       :version     +version+
       :description "Preact is a fast, 3kb alternative to React, with the same ES2015 API."
       :url         "https://preactjs.com"
       :scm         {:url "https://github.com/developit/preact"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})


(deftask package []
  (comp
    (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/preact/" +lib-version+ "/preact.js")
              :checksum "20eb698062a9bd0d8873629b53ed0e05")
    (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/preact/" +lib-version+ "/preact.min.js")
              :checksum "7cca97dc132ebebd01cd21e5c8b95ae1")
    (sift :move {#"preact\.js" "cljsjs/preact/development/preact.inc.js"
                 #"preact\.min\.js" "cljsjs/preact/production/preact.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.preact")
    (pom)
    (jar)))
