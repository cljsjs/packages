(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot])

(def +lib-version+ "0.4.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/dialog-polyfill
       :version     +version+
       :description "Polyfill for the dialog element"
       :url         "https://github.com/GoogleChrome/dialog-polyfill"
       :license     {"BSD" "https://opensource.org/licenses/BSD-3-Clause"}
       :scm         {:url "https://github.com/GoogleChrome/dialog-polyfill"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/GoogleChrome/dialog-polyfill/archive/" +lib-version+ ".zip")
             :checksum "19bee23e1ba568368aab5e8c8cf9657f"
             :unzip true)
   (sift :move {#"^dialog-polyfill-[^/]+/dialog-polyfill.js" "cljsjs/dialog-polyfill/development/dialog-polyfill.inc.js"})
   (minify :in "cljsjs/dialog-polyfill/development/dialog-polyfill.inc.js"
           :out "cljsjs/dialog-polyfill/production/dialog-polyfill.min.inc.js"
           :lang :ecmascript5)
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.dialog-polyfill")
   (pom)
   (jar)))
