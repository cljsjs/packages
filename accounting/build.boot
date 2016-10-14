(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.2"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot])

(def +lib-version+ "0.4.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/accounting
       :version     +version+
       :description "accounting.js is a tiny JavaScript library by Open Exchange Rates, providing simple and advanced number, money and currency formatting."
       :url         "http://openexchangerates.github.io/accounting.js/"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url "https://raw.githubusercontent.com/openexchangerates/accounting.js/master/accounting.js"
             :checksum "56982C70B6A0114ADCE46ECAAC5B3B1B")
   (download :url "https://raw.githubusercontent.com/openexchangerates/accounting.js/master/accounting.min.js"
             :checksum "B34EE54ABCDDA3F94566EA5E7312FDBC")
   (sift :move {#"^accounting.js" "cljsjs/accounting/development/accounting.inc.js"
                #"^accounting.min.js" "cljsjs/accounting/production/accounting.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.accounting")
   (pom)
   (jar)))
