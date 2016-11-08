
(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "6.0.0")
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
              :checksum "03d2993b692643a21b0fc25cae936533")
    (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/preact/" +lib-version+ "/preact.min.js")
              :checksum "23d3be42e4b4c25b76f7ac88f976eccb")
    (sift :move {#"preact\.js" "cljsjs/preact/development/preact.inc.js"
                 #"preact\.min\.js" "cljsjs/preact/production/preact.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.preact")
    (pom)
    (jar)))
