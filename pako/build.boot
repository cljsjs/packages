(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.2.5-0")
(bootlaces! +version+)

(task-options!
  pom  {:project     'cljsjs/pako
        :version     +version+
        :description "zlib port to javascript, very fast!"
        :url         "http://nodeca.github.io/pako/"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url "https://github.com/nodeca/pako/archive/0.2.5.zip"
              :checksum "8392ad105d913c3a83a7787c8f148055"
              :unzip true)
    (sift :move {#"^pako-.*/dist/pako.js"    "cljsjs/pako/development/pako.inc.js"
                #"^pako-.*/dist/pako.min.js" "cljsjs/pako/production/pako.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.pako")))
