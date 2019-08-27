(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "6.20.0")
(def +version+ (str +lib-version+ "-2"))

(task-options!
  pom {:project     'cljsjs/babel-polyfill
       :version     +version+
       :description "Provides polyfills necessary for a full ES2015+ environment."
       :url         "https://github.com/babel/babel/tree/master/packages/babel-polyfill"
       :scm         {:url "https://github.com/SMX-LTD/cljsjs-packages"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/babel-polyfill/" +lib-version+ "/polyfill.js"))
    (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/babel-polyfill/" +lib-version+ "/polyfill.min.js"))
    (sift :move {#"polyfill.js"     "cljsjs/babel-polyfill/development/polyfill.inc.js"
                 #"polyfill.min.js" "cljsjs/babel-polyfill/production/polyfill.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.babel-polyfill")
    (pom)
    (jar)))

