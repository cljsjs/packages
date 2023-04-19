(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.1.0")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  pom  {:project     'cljsjs/buffer
        :version     +version+
        :description "Node-style buffer in the browser."
        :url         "https://github.com/feross/buffer"
        :license     {"MIT" "https://github.com/feross/buffer/blob/master/LICENSE"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask build-buffer []
  (run-commands :commands [["npm" "install" "--include-dev"]
                           ["npm" "run" "bundle"]
                           ["npm" "run" "generate-extern"]
                           ["rm" "-rf" "./node_modules"]]))

(deftask package []
  (comp
    (build-buffer)
    (sift :move {#".*buffer.bundle.js" "cljsjs/buffer/development/buffer.inc.js"
                 #".*buffer.ext.js" "cljsjs/buffer/common/buffer.ext.js"})
    (minify :in "cljsjs/buffer/development/buffer.inc.js"
            :out "cljsjs/buffer/production/buffer.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.buffer")
    (pom)
    (jar)))
