(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.1.3")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  push {:ensure-clean false}
  pom  {:project     'cljsjs/big
        :version     +version+
        :description "A JavaScript library for arbitrary-precision decimal and non-decimal arithmetic."
        :url         "http://mikemcl.github.io/big.js/"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/MikeMcl/big.js/archive/v%s.zip" +lib-version+)
              :checksum "36B3248F4CBC85D65D1DEF1688A56F8B"
              :unzip true)
    (sift :move {#"^big.js-[^\/]*/big\.js"      "cljsjs/big/development/big.inc.js"
                 #"^big.js-[^\/]*/big\.min\.js" "cljsjs/big/production/big.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.big")
    (pom)
    (jar)))
