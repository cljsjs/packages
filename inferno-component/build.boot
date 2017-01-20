
(def +lib-version+ "1.2.1")
(def +version+ (str +lib-version+ "-0"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/inferno-component
       :version     +version+
       :description "Inferno package for working with ES2015 stateful components"
       :url         "https://github.com/trueadm/inferno"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(defn download-cdn []
  (download :url (str "https://unpkg.com/inferno@" +lib-version+ "/dist/inferno-component.js")
            :checksum "cb9bd707201297d8ef8b6d5462c7cd1e"))

(defn download-min-cdn []
  (download :url (str "https://unpkg.com/inferno@" +lib-version+ "/dist/inferno-component.min.js")
            :checksum "3ffcba2ecd9b0ccf26d01217acb214c5"))

(deftask package  []
  (comp
    (download-cdn)
    (download-min-cdn)
    (sift :move {#"^inferno-component\.min\.js$"
                 "cljsjs/inferno/production/inferno-component.min.inc.js"
                 #"^inferno-component\.js$"
                 "cljsjs/inferno/development/inferno-component.inc.js"})
    (sift :include #{#"^cljs"})
    (deps-cljs :name "cljsjs.inferno.component" :requires ["cljsjs.inferno"])
    (pom)
    (jar)
    (target)))
