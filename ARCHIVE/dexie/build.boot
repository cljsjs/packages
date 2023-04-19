(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.4")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/dexie
       :version     +version+
       :description "A Minimalistic Wrapper for IndexedDB"
       :url         "http://dexie.org/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache" "http://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (comp
   (download :url (format "https://github.com/dfahlander/Dexie.js/archive/v%s.zip" +lib-version+)
             :unzip true)
   (sift :move {#"^Dexie\.js-([\d\.]*)/dist/dexie\.js" "cljsjs/production/dexie.min.inc.js"})
   (sift :move {#"^Dexie\.js-([\d\.]*)/dist/dexie\.min\.js" "cljsjs/development/dexie.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.dexie")
   (pom)
   (jar)
   (validate)))
