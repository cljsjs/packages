(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "1.2.10-0")
(bootlaces! +version+)

(task-options!
 push {:ensure-clean false}
 pom  {:project     'cljsjs/localForage
       :version     +version+
       :description "localForage is a fast and simple storage library for JavaScript. localForage improves the offline experience of your web app by using asynchronous storage (IndexedDB or WebSQL) with a simple, localStorage-like API."
       :url         "https://github.com/mozilla/localForage"
       :license     {"License" "https://raw.githubusercontent.com/mozilla/localForage/master/LICENSE"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url "https://github.com/mozilla/localForage/archive/1.2.10.zip"
             :checksum "7f219bc138eee32fba80e79d6179872a"
             :unzip true)
   (sift :move {#"^localForage-.*/dist/localforage.js$" "cljsjs/development/localforage.inc.js"})
   (minify :in "cljsjs/development/localforage.inc.js"
           :out "cljsjs/production/localforage.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.localForage")))
