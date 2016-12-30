(def +lib-version+ "1.0.3")
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
            :checksum "2D195D41970A936CAA30A1A686602E45"))

(defn download-min-cdn []
  (download :url (str "https://unpkg.com/inferno@" +lib-version+ "/dist/inferno.min.js")
            :checksum "7954BCC2C41866066B82DF325BEC929F"))

(deftask package  []
  (task-options! push {:ensure-branch nil :tag false})
  (comp
    (download-cdn)
    (download-min-cdn)
    (sift :move {#"^inferno\.min\.js$"
                 "cljsjs/inferno/production/inferno.min.inc.js"
                 #"^inferno\.js$"
                 "cljsjs/inferno/development/inferno.inc.js"})
    (sift :include #{#"^cljs"})
    (deps-cljs :name "cljs.inferno")
    (pom)
    (jar)))
