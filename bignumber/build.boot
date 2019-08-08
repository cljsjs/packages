(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.1.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  push {:ensure-clean false}
  pom  {:project     'cljsjs/bignumber
        :version     +version+
        :description "A JavaScript library for arbitrary-precision decimal and non-decimal arithmetic."
        :url         "http://mikemcl.github.io/bignumber.js"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/MikeMcl/bignumber.js/archive/v%s.zip" +lib-version+)
              :checksum "78d7864c66e9f79043ae3c65d7f6f322"
              :unzip true)
    (sift :move {#"^bignumber.js-[^\/]*/bignumber\.js"      "cljsjs/bignumber/development/bignumber.inc.js"
                 #"^bignumber.js-[^\/]*/bignumber\.min\.js" "cljsjs/bignumber/production/bignumber.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.bignumber")
    (pom)
    (jar)))
