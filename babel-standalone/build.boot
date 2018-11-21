(set-env!
  :resource-paths #{"src"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                  [org.clojure/clojurescript "1.9.456" :scope "provided"]
                  [org.clojure/data.json "0.2.6"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "6.18.1")
(def +version+ (str +lib-version+ "-3"))

(task-options!
 pom  {:project     'cljsjs/babel-standalone
       :version     +version+
       :description "Standalone build of Babel for use in non-Node.js environments, including browsers. Similar to the (now deprecated) babel-browser."
       :url         "https://babeljs.io/repl"
       :scm         {:url "https://github.com/babel/babel-standalone"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})


(deftask package []
  (comp
    (download :url (format "https://cdnjs.cloudflare.com/ajax/libs/babel-standalone/%s/babel.js" +lib-version+))
    (download :url (format "https://cdnjs.cloudflare.com/ajax/libs/babel-standalone/%s/babel.min.js" +lib-version+))
    (sift :move {#"babel\.js" "cljsjs/babel-standalone/development/babel.inc.js"
                 #"babel\.min\.js" "cljsjs/babel-standalone/production/babel.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.babel-standalone" :no-externs true)
    (pom)
    (jar)))

