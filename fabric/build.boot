(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.5.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/fabric
       :version     +version+
       :description "Fabric.js is a powerful and simple Javascript HTML5 canvas library"
       :url         "http://fabricjs.com"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (format "https://raw.githubusercontent.com/kangax/fabric.js/v%s/dist/fabric.js" +lib-version+)
              :checksum "55D8FAC6D57FA1E1C9C2E2900D37AF07")
    (download :url (format "https://raw.githubusercontent.com/kangax/fabric.js/v%s/dist/fabric.min.js" +lib-version+)
              :checksum "729F6076F0C6D3C33D9059A45C59216D")
    (replace-content :in "fabric.min.js" :match #"(?m)^//# sourceMappingURL=.*$" :value "")
    (sift :move {#"^fabric.js"     "cljsjs/fabric/development/fabric.inc.js"
                 #"^fabric.min.js" "cljsjs/fabric/production/fabric.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.fabric")
    (pom)
    (jar)))
