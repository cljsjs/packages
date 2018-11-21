(set-env!
  :resource-paths #{"resources"}
  :dependencies   '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.3.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project 'cljsjs/fela-dom
       :version +version+
       :description "DOM bindings for fela.js"
       :url "https://github.com/rofrischmann/fela/tree/master/packages/fela-dom"
       :scm {:url "https://github.com/cljsjs/packages"}
       :license { "MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://unpkg.com/fela-dom@" +lib-version+ "/dist/fela-dom.js")
              :checksum "42855a6fe7d3f68a0cea2e7bef5310f6")
    (download :url (str "https://unpkg.com/fela-dom@" +lib-version+ "/dist/fela-dom.min.js")
              :checksum "486b255e803beb3ede385c3f072a1f9d")
    (sift :move {#"^fela-dom.js$" "cljsjs/fela-dom/development/fela-dom.inc.js"
                 #"^fela-dom.min.js$" "cljsjs/fela-dom/production/fela-dom.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.fela-dom")
    (pom)
    (jar)))
