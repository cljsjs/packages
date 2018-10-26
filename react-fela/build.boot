(def +lib-version+ "4.3.5")
(def +version+ (str +lib-version+ "-0"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies   [['cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                   ['cljsjs/react "15.5.4-0"]
                   ['cljsjs/fela +version+]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
  pom {:project 'cljsjs/react-fela
       :version +version+
       :description "Official React bindings for Fela."
       :url "https://github.com/rofrischmann/fela/tree/master/packages/react-fela"
       :scm {:url "https://github.com/cljsjs/packages"}
       :license { "MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://unpkg.com/react-fela@" +lib-version+ "/dist/react-fela.js")
              :checksum "236D542855256D9A95A349ADED77B6B3")
    (download :url (str "https://unpkg.com/react-fela@" +lib-version+ "/dist/react-fela.min.js")
              :checksum "B8EDCDE5C244701809755A48BBFBB429")
  (sift :move {#"^react-fela\.js" "cljsjs/react-fela/development/react-fela.inc.js"
               #"^react-fela\.min\.js" "cljsjs/react-fela/production/react-fela.min.inc.js"})
  (sift :include #{#"^cljsjs"})
  (deps-cljs :name "cljsjs.react-fela"
             :requires ["cljsjs.react"
                        "cljsjs.fela"])
  (pom)
  (jar)))
