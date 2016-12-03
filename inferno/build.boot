(def +lib-version+ "1.0.0-beta22")
(def +version+ (str +lib-version+ ""))

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
  (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/inferno/" +lib-version+ "/inferno.js")
            :checksum "4A7D0481D3A8A09365D5342F698A0A5D"))

(defn download-min-cdn []
  (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/inferno/" +lib-version+ "/inferno.min.js")
            :checksum "43F965E1DE8E181F0EC6877AA189E59E"))

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
