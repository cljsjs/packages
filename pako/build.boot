(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.11" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.2.7-0")
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
    (download :url "https://raw.githubusercontent.com/nodeca/pako/0.2.7/dist/pako.min.js"
              :checksum "880935149cdc811080cf815e175af12a")
    (download :url "https://raw.githubusercontent.com/nodeca/pako/0.2.7/dist/pako.js"
              :checksum "4bfb3a0fa3ac7831b02cc296666ca4e9")
    (sift :move {#"pako\.js"      "cljsjs/pako/development/pako.inc.js"
                 #"pako\.min\.js" "cljsjs/pako/production/pako.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.pako")))
