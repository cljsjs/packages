(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(def +lib-version+ "1.0.1")
(def +version+ (str +lib-version+ "-0"))

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
  pom {:project     'cljsjs/mithril
       :version     +version+
       :description "A Javascript Framework for Building Brilliant Applications"
       :url         "http://mithril.js.org/"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/lhorie/mithril.js/archive/v" +lib-version+ ".zip")
             :unzip true)
   (sift :move {#"^mithril\.js-([\d\.]*)/mithril\.js"      "cljsjs/mithril/development/mithril.inc.js"
                #"^mithril\.js-([\d\.]*)/mithril\.min\.js" "cljsjs/mithril/production/mithril.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.mithril")
   (pom)
   (jar)))
