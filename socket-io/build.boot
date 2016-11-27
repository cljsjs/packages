(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.13" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.6.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/socket-io
       :version     +version+
       :description ""
       :url         "https://github.com/socketio/socket.io"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/socket.io/" +lib-version+ "/socket.io.js")
              :checksum "25C4C6610F9CC7AB58B9EB2E5E9EC8E1")
    (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/socket.io/" +lib-version+ "/socket.io.min.js")
              :checksum "8C95B98A636A39DF32C396D665EF6908")
    (sift :move {#"socket.io.js" "cljsjs/development/socket.io.inc.js"
                 #"socket.io.min.js" "cljsjs/production/socket.io.min.inc.js"}
          :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.socket-io")
    (pom)
    (jar)))
