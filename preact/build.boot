
(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "7.1.0")
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
              :checksum "38c4f97737f048a57f9d0408dcddd2e8")
    (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/preact/" +lib-version+ "/preact.min.js")
              :checksum "2a0b925a7535a9f00ec94a86348d3077")
    (sift :move {#"preact\.js" "cljsjs/preact/development/preact.inc.js"
                 #"preact\.min\.js" "cljsjs/preact/production/preact.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.preact")
    (pom)
    (jar)))
