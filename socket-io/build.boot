(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.13" :scope "test"]
                  [cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.1")
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
              :checksum "B72B90D6087DB2C4D9A2A5810C93108B")
    (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/socket.io/" +lib-version+ "/socket.io.slim.js")
              :checksum "B662B0A146686B726716C16F62EB5EFE")
    (sift :move {#"socket.io.js" "cljsjs/development/socket.io.inc.js"
                 #"socket.io.slim.js" "cljsjs/production/socket.io.min.inc.js"}
          :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.socket-io")
    (pom)
    (jar)))
