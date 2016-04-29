(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.3.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/spin
      :version     +version+
      :description "A spinning activity indicator"
      :url         "http://spin.js.org"
      :scm         {:url "https://github.com/fgnass/spin.js"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/fgnass/spin.js/archive/" +lib-version+ ".zip")
              :checksum "71a0e4985a2711589f2e5eecfec3e416"
              :unzip true)
    (sift :move {#"^spin\.js-([\d.]*)/spin\.js" "cljsjs/spin/development/spin.inc.js"
                 #"^spin\.js-([\d.]*)/spin\.min\.js" "cljsjs/spin/production/spin.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.spin")
    (pom)
    (jar)))
