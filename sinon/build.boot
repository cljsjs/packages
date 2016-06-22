(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.17.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 push {:ensure-clean false}
 pom  {:project     'cljsjs/sinon
       :version     +version+
       :description "Standalone test spies, stubs and mocks for JavaScript"
       :url         "https://github.com/cjohansen/Sinon.JS"
       :license     {"License" "https://raw.githubusercontent.com/sinonjs/sinon/master/LICENSE"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (format "http://sinonjs.org/releases/sinon-%s.js" +lib-version+)
             :checksum "c949ffb010af1a0ffd168684da4c2678")
   (sift :move {#"^sinon-.*.js$" "cljsjs/development/sinon.inc.js"})
   (minify :in "cljsjs/development/sinon.inc.js" :out "cljsjs/production/sinon.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.sinon")
   (pom)
   (jar)))
