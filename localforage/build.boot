(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.3.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 push {:ensure-clean false}
 pom  {:project     'cljsjs/localforage
       :version     +version+
       :description "localForage is a fast and simple storage library for JavaScript. localForage improves the offline experience of your web app by using asynchronous storage (IndexedDB or WebSQL) with a simple, localStorage-like API."
       :url         "https://github.com/mozilla/localForage"
       :license     {"License" "https://raw.githubusercontent.com/mozilla/localForage/master/LICENSE"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (format "https://github.com/mozilla/localForage/archive/%s.zip" +lib-version+)
             :checksum "448FC6ABC00AA894F8B1437DB03EA0AA"
             :unzip true)
   (sift :move {#"^localForage-.*/dist/localforage.js$" "cljsjs/localforage/development/localforage.inc.js"})
   (minify :in "cljsjs/localforage/development/localforage.inc.js"
           :out "cljsjs/localforage/production/localforage.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.localforage")))
