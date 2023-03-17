(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.4")
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
              :checksum "07AE3B6B3B89501942776C01CC7F195A")
    (download :url (format "https://raw.githubusercontent.com/nodeca/pako/%s/dist/pako.js" +lib-version+)
              :checksum "CB12C4770AA72A59132194D60ACB97B6")
    (sift :move {#"pako\.js"      "cljsjs/pako/development/pako.inc.js"
                 #"pako\.min\.js" "cljsjs/pako/production/pako.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.pako")
    (pom)
    (jar)))
