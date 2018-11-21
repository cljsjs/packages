(set-env!
  :resource-paths #{"resources"}
  :dependencies   '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.3.5")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project 'cljsjs/fela-preset-dev
       :version +version+
       :description "A Fela plugin preset for development."
       :url "https://github.com/rofrischmann/fela/tree/master/packages/fela-preset-dev"
       :scm {:url "https://github.com/cljsjs/packages"}
       :license { "MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://unpkg.com/fela-preset-dev@" +lib-version+ "/dist/fela-preset-dev.js")
              :checksum "50241A874B1B90DFF7FAAA5D2CE35242")
    (download :url (str "https://unpkg.com/fela-preset-dev@" +lib-version+ "/dist/fela-preset-dev.min.js")
              :checksum "94B90E2DB7746D46E9D4952D17A600AD")
    (sift :move {#"^fela-preset-dev.js$" "cljsjs/fela-preset-dev/development/fela-preset-dev.inc.js"
                 #"^fela-preset-dev.min.js$" "cljsjs/fela-preset-dev/production/fela-preset-dev.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.fela-preset-dev")
    (pom)
    (jar)))
