(set-env!
  :resource-paths #{"resources"}
  :dependencies   '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.3.5")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project 'cljsjs/fela-preset-web
       :version +version+
       :description "A Fela plugin preset for web applications."
       :url "https://github.com/rofrischmann/fela/tree/master/packages/fela-preset-web"
       :scm {:url "https://github.com/cljsjs/packages"}
       :license { "MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://unpkg.com/fela-preset-web@" +lib-version+ "/dist/fela-preset-web.js")
              :checksum "167AE88FB8B1FA45065D76DE080C72FF")
    (download :url (str "https://unpkg.com/fela-preset-web@" +lib-version+ "/dist/fela-preset-web.min.js")
              :checksum "B81EC0F4105A2B3928C74AEEC2AC7044")
    (sift :move {#"^fela-preset-web.js$" "cljsjs/fela-preset-web/development/fela-preset-web.inc.js"
                 #"^fela-preset-web.min.js$" "cljsjs/fela-preset-web/production/fela-preset-web.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.fela-preset-web")
    (pom)
    (jar)))
