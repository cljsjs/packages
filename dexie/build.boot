(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.2.0")
(def +version+ (str +lib-version+ "-1"))

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
             :checksum "317f28e3830545e213bd7a3950026065"
             :unzip true)
   (sift :move {#"^Dexie\.js-([\d\.]*)/dist/latest/Dexie\.js"     "cljsjs/production/dexie.min.inc.js"})
   (sift :move {#"^Dexie\.js-([\d\.]*)/dist/latest/Dexie\.min\.js"     "cljsjs/development/dexie.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.dexie")
   (pom)
   (jar)))
