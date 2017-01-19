(def +lib-version+ "1.2.1")
(def +version+ (str +lib-version+ "-0"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/inferno-create-element
       :version     +version+
       :description "Inferno package with helpers to create Inferno elements"
       :url         "https://github.com/infernojs/inferno/tree/master/packages/inferno-create-element"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(defn download-cdn []
  (download :url (str "https://unpkg.com/inferno@" +lib-version+ "/dist/inferno-create-element.js")
            :checksum "0f5511413c7806ce47f07a1a49b268d2"))

(defn download-min-cdn []
  (download :url (str "https://unpkg.com/inferno@" +lib-version+ "/dist/inferno-create-element.min.js")
            :checksum "8498b6f8754e247c5c56adbc156de6bc"))

(deftask package  []
  (comp
    (download-cdn)
    (download-min-cdn)
    (sift :move {#"^inferno-create-element\.min\.js$"
                 "cljsjs/inferno/production/inferno-create-element.min.inc.js"
                 #"^inferno-create-element\.js$"
                 "cljsjs/inferno/development/inferno-create-element.inc.js"})
    (sift :include #{#"^cljs"})
    (deps-cljs :name "cljsjs.inferno.create-element")
    (pom)
    (jar)))
