(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.2.7")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/pako
        :version     +version+
        :description "zlib port to javascript, very fast!"
        :url         "http://nodeca.github.io/pako/"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url (format "https://raw.githubusercontent.com/nodeca/pako/%s/dist/pako.min.js" +lib-version+)
              :checksum "880935149cdc811080cf815e175af12a")
    (download :url (format "https://raw.githubusercontent.com/nodeca/pako/%s/dist/pako.js" +lib-version+)
              :checksum "4bfb3a0fa3ac7831b02cc296666ca4e9")
    (sift :move {#"pako\.js"      "cljsjs/pako/development/pako.inc.js"
                 #"pako\.min\.js" "cljsjs/pako/production/pako.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.pako")))
