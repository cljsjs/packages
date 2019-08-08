(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/qart
        :version     +version+
        :description "Generate artistic QR code."
        :url         "https://github.com/kciter/qart.js"
        :license     {"GPLv3" "https://raw.githubusercontent.com/kciter/qart.js/master/LICENSE"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/kciter/qart.js/archive/" +lib-version+ ".zip")
             :checksum "965060aeb8954942c8f1164f6f27497f"
             :unzip true)
   (sift :move {#"^qart.js-.*/dist/qart.js" "cljsjs/qart/development/qart.inc.js"
                #"^qart.js-.*/dist/qart.min.js" "cljsjs/qart/production/qart.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.qart")
    (pom)
    (jar)))
