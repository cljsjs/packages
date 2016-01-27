(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.1.4")
(def +version+ (str +lib-version+ "-1"))

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
              :checksum "8172f22467a2fdab2e11b47a0ece11dc"
              :unzip true)
    (sift :move {#"^bignumber.js-[^\/]*/bignumber\.js"      "cljsjs/bignumber/development/bignumber.inc.js"
                 #"^bignumber.js-[^\/]*/bignumber\.min\.js" "cljsjs/bignumber/production/bignumber.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.bignumber")))
