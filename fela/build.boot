(set-env!
  :resource-paths #{"resources"}
  :dependencies   '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.3.5")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project 'cljsjs/fela
       :version +version+
       :description "Fela is a fast and modular library to handle styling in JavaScript."
       :url "https://github.com/rofrischmann/fela"
       :scm {:url "https://github.com/cljsjs/packages"}
       :license { "MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://unpkg.com/fela@" +lib-version+ "/dist/fela.js")
              :checksum "AE993D823C849809F85946BD46ACCC9A")
    (download :url (str "https://unpkg.com/fela@" +lib-version+ "/dist/fela.min.js")
              :checksum "454EF3B6EC848B5AF9465ACB1E24706C")
  (sift :move {#"^fela\.js" "cljsjs/fela/development/fela.inc.js"
               #"^fela\.min\.js" "cljsjs/fela/production/fela.min.inc.js"})
  (sift :include #{#"^cljsjs"})
  (deps-cljs :name "cljsjs.fela")
  (pom)
  (jar)))
