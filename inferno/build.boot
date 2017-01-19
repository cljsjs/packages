(def +lib-version+ "1.2.1")
(def +version+ (str +lib-version+ "-0"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/inferno
       :version     +version+
       :description "Inferno is an insanely fast, 7kb React-like library for building high-performance user interfaces on both the client and server."
       :url         "https://github.com/trueadm/inferno"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(defn download-cdn []
  (download :url (str "https://unpkg.com/inferno@" +lib-version+ "/dist/inferno.js")
            :checksum "a584b6e19369e13845ad49ee4153ea9a"))

(defn download-min-cdn []
  (download :url (str "https://unpkg.com/inferno@" +lib-version+ "/dist/inferno.min.js")
            :checksum "e483e2f41e51f1067b9762eb9fbd9882"))

(deftask package  []
  (comp
    (download-cdn)
    (download-min-cdn)
    (sift :move {#"^inferno\.min\.js$"
                 "cljsjs/inferno/production/inferno.min.inc.js"
                 #"^inferno\.js$"
                 "cljsjs/inferno/development/inferno.inc.js"})
    (sift :include #{#"^cljs"})
    (deps-cljs :name "cljsjs.inferno")
    (pom)
    (jar)))
