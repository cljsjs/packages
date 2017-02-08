(set-env!
  :resource-paths #{"src"}
  :dependencies '[[cljsjs/boot-cljsjs "0.6.0" :scope "test"]
                  [org.clojure/clojurescript "1.9.456" :scope "provided"]
                  [org.clojure/data.json "0.2.6"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "6.18.1")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/babel-standalone
       :version     +version+
       :description "Standalone build of Babel for use in non-Node.js environments, including browsers. Similar to the (now deprecated) babel-browser."
       :url         "https://babeljs.io/repl"
       :scm         {:url "https://github.com/babel/babel-standalone"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})


(deftask package []
  (comp
    (download :url (format "https://cdnjs.cloudflare.com/ajax/libs/babel-standalone/%s/babel.min.js" +lib-version+)
              :checksum "F22EF4422B643D1FC3900CBAB4DB4D9D")
    (sift :move {#"babel\.min\.js" "cljsjs/babel-standalone/production/babel.min.js"})
    (sift :include #{#"^cljsjs"})
    (pom)
    (jar)))

