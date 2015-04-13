(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.2.6-0")
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
    (download :url "https://raw.githubusercontent.com/nodeca/pako/0.2.6/dist/pako.min.js"
              :checksum "960cb8305a01413a3c59459578be1a94")
    (download :url "https://raw.githubusercontent.com/nodeca/pako/0.2.6/dist/pako.js"
              :checksum "393c0e574e439c37025d56141d6e8bff")
    (sift :move {#"pako\.js"      "cljsjs/pako/development/pako.inc.js"
                 #"pako\.min\.js" "cljsjs/pako/production/pako.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.pako")))
