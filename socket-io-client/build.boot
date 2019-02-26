(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.13" :scope "test"]
                  [cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.1.1")
(def +version+ (str +lib-version+ "-0"))

(def unpkg-dist-url (str "https://unpkg.com/socket.io-client@" +lib-version+ "/dist"))

(task-options!
 pom  {:project     'cljsjs/socket-io-client
       :version     +version+
       :description ""
       :url         "https://github.com/socketio/socket.io-client"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str unpkg-dist-url "/socket.io.js"))
    (download :url (str unpkg-dist-url "/socket.io.slim.js"))

    (sift :move {#"socket.io.js" "cljsjs/development/socket.io.inc.js"
                 #"socket.io.slim.js" "cljsjs/production/socket.io.min.inc.js"}
          :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.socket-io-client")

    (pom)

    (jar)

    (validate)))

