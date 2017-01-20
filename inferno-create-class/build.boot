
(def +lib-version+ "1.2.1")
(def +version+ (str +lib-version+ "-0"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/inferno-create-class
       :version     +version+
       :description "Provides a helper to create Inferno Components without needing ES2015"
       :url         "https://github.com/infernojs/inferno/tree/master/packages/inferno-create-class"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(defn download-cdn []
  (download :url (str "https://unpkg.com/inferno@" +lib-version+ "/dist/inferno-create-class.js")
            :checksum "c6c3275d562cfdd6f89248780cb5628e"))

(defn download-min-cdn []
  (download :url (str "https://unpkg.com/inferno@" +lib-version+ "/dist/inferno-create-class.min.js")
            :checksum "1086e16638d2507bc2049efa4c725b77"))

(deftask package  []
  (comp
    (download-cdn)
    (download-min-cdn)
    (sift :move {#"^inferno-create-class\.min\.js$"
                 "cljsjs/inferno/production/inferno-create-class.min.inc.js"
                 #"^inferno-create-class\.js$"
                 "cljsjs/inferno/development/inferno-create-class.inc.js"})
    (sift :include #{#"^cljs"})
    (deps-cljs :name "cljsjs.inferno.create-class" :requires ["cljsjs.inferno" "cljsjs.inferno.component"])
    (pom)
    (jar)))
