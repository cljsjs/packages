(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.9.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot])

(def +lib-version+ "1.6.1")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/clipboard
       :version     +version+
       :description "Modern copy to clipboard. No Flash. Just 2kb"
       :url         "http://clipboardjs.com"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/zenorocha/clipboard.js"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/zenorocha/clipboard.js/archive/v" +lib-version+ ".zip")
             :checksum "0ffb60261a8e3a15071165e3b194925d"
             :unzip true)
   (sift :move {#"^clipboard.js-[^/]+/dist/clipboard.js" "cljsjs/clipboard/development/clipboard.inc.js"})
   (sift :move {#"^clipboard.js-[^/]+/dist/clipboard.min.js" "cljsjs/clipboard/production/clipboard.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.clipboard")
   (pom)
   (jar)))
