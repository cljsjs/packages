(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "6.1.4")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 push {:ensure-clean false}
 pom  {:project     'cljsjs/sinon
       :version     +version+
       :description "Standalone test spies, stubs and mocks for JavaScript"
       :url         "https://github.com/sinonjs/sinon"
       :license     {"License" "https://raw.githubusercontent.com/sinonjs/sinon/master/LICENSE"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (format "http://sinonjs.org/releases/sinon-%s.js" +lib-version+))
   (sift :move {#"^sinon-.*.js$" "cljsjs/development/sinon.inc.js"})
   (minify :in "cljsjs/development/sinon.inc.js" :out "cljsjs/production/sinon.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.sinon")
   (pom)
   (jar)
   (validate)))
