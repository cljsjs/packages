(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.2.2")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom {:project     'cljsjs/humane
      :version     +version+
      :description "A simple, modern, browser notification system"
      :url         "http://wavded.github.io/humane-js/"
      :scm         {:url "https://github.com/wavded/humane-js"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/wavded/humane-js/archive/" +lib-version+ ".zip")
              :checksum "27FDB5B728D55060A1D6007D935C0664"
              :unzip true)
    (sift :move {#"^humane-js-([\d.]*)/humane\.js" "cljsjs/humane/development/humane.inc.js"
                 #"^humane-js-([\d.]*)/humane\.min\.js" "cljsjs/humane/production/humane.min.inc.js"
                 #"^humane-js-([\d.]*)/themes" "cljsjs/humane/common/themes"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.humane")
    (pom)
    (jar)))
