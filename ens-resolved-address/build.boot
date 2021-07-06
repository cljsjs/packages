(def +lib-version+ "0.0.31")
(def +version+ (str +lib-version+ "-0"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                  [cljsjs/react "16.0.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'io.github.cljsjs/ens-resolved-address
       :version     +version+
       :description "A draggable and resizable grid layout with responsive breakpoints, for React."
       :url         "https://github.com/touhonoob/ens-resolved-address"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/touhonoob/ens-resolved-address/archive/refs/heads/dist.zip")
              :unzip true)

    (sift :move {#"^ens-resolved-address-(.*)/dist/ens-resolved-address.min.js$" "cljsjs/ens-resolved-address/development/ens-resolved-address.inc.js"})

    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.ens-resolved-address"
               :requires ["cljsjs.react"])
    (pom)
    (jar)
    (validate)))
