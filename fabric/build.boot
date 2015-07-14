(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "1.5.0-0")

(task-options!
 pom  {:project     'cljsjs/fabric
       :version     +version+
       :description "Fabric.js is a powerful and simple Javascript HTML5 canvas library"
       :url         "http://fabricjs.com"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url "https://raw.githubusercontent.com/kangax/fabric.js/v1.5.0/dist/fabric.js"
              :checksum "55D8FAC6D57FA1E1C9C2E2900D37AF07")
    (download :url "https://raw.githubusercontent.com/kangax/fabric.js/v1.5.0/dist/fabric.min.js"
              :checksum "729F6076F0C6D3C33D9059A45C59216D")
    (replace-content :in "fabric.min.js" :match #"(?m)^//# sourceMappingURL=.*$" :value "")
    (sift :move {#"^fabric.js"     "cljsjs/fabric/development/fabric.inc.js"
                 #"^fabric.min.js" "cljsjs/fabric/production/fabric.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.fabric")))
