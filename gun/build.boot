(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.6.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/gun
       :version     +version+
       :description "GUN is a realtime, distributed, offline-first, graph database engine"
       :url         "https://github.com/amark/gun"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/gun@%s/gun.js" +lib-version+)
             :checksum "DE9F2F07DE3F1F5A5ED349190E509C43")
   (download :url (format "https://unpkg.com/gun@%s/gun.min.js" +lib-version+)
             :checksum "2AB474C5E776684700F948506846F463")
   (sift :move {#".*gun\.js$"   "cljsjs/gun/development/gun.inc.js"})
   (sift :move {#".*gun\.min\.js$"   "cljsjs/gun/production/gun.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.gun")
   (pom)
   (jar)))
