(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot])

(def +lib-version+ "0.4.1")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/accounting
       :version     +version+
       :description "accounting.js is a tiny JavaScript library by Open Exchange Rates, providing simple and advanced number, money and currency formatting."
       :url         "http://openexchangerates.github.io/accounting.js/"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/openexchangerates/accounting.js/archive/v" +lib-version+ ".zip")
             :checksum "F430D852899F31651137D615DFFB8706"
             :unzip true)
             (show :fileset true) 
   (sift :move {#"^accounting\.js-.*/accounting.js" "cljsjs/accounting/development/accounting.inc.js"
                #"^accounting\.js.*/accounting.min.js" "cljsjs/accounting/production/accounting.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.accounting")
   (pom)
   (jar)))
