(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.7.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.1.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/buffer
        :version     +version+
        :description "Node-style buffer in the browser."
        :url         "https://github.com/feross/buffer"
        :license     {"MIT" "https://github.com/feross/buffer/blob/master/LICENSE"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url (str "https://wzrd.in/standalone/buffer@" +lib-version+))
    (sift :move {(re-pattern (str "^buffer@" +lib-version+)) "cljsjs/buffer/development/buffer.inc.js"})
    (minify :in "cljsjs/buffer/development/buffer.inc.js"
            :out "cljsjs/buffer/production/buffer.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.buffer")
    (pom)
    (jar)))
