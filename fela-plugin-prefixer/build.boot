(set-env!
  :resource-paths #{"resources"}
  :dependencies   '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.3.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project 'cljsjs/fela-plugin-prefixer
       :version +version+
       :description "a plugin for automatic vendor prefixing for fela.js"
       :url "https://github.com/rofrischmann/fela/tree/master/packages/fela-plugin-prefixer"
       :scm {:url "https://github.com/cljsjs/packages"}
       :license { "MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://unpkg.com/fela-plugin-prefixer@" +lib-version+ "/dist/fela-plugin-prefixer.js")
              :checksum "038c38ee9d3d539c93626bdc6512ab42")
    (download :url (str "https://unpkg.com/fela-plugin-prefixer@" +lib-version+ "/dist/fela-plugin-prefixer.min.js")
              :checksum "1a3ca2196aa7cc9730792a6779b1143a")
    (sift :move {#"^fela-plugin-prefixer.js$" "cljsjs/fela-plugin-prefixer/development/fela-plugin-prefixer.inc.js"
                 #"^fela-plugin-prefixer.min.js$" "cljsjs/fela-plugin-prefixer/production/fela-plugin-prefixer.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.fela-plugin-prefixer")
    (pom)
    (jar)))
