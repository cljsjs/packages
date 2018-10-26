(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.1.8")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  pom {:project     'cljsjs/absinthe-socket
       :version     +version+
       :description "Core JavaScript support for Absinthe WS-based operations"
       :url         "https://github.com/absinthe-graphql/absinthe-socket"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/@absinthe/socket@%s/compat/umd/index.js" +lib-version+)
             :target "cljsjs/absinthe-socket/development/absinthe-socket.inc.js")

   (download :url (format "https://unpkg.com/@absinthe/socket@%s/compat/umd/index.js" +lib-version+)
             :target "cljsjs/absinthe-socket/production/absinthe-socket.min.inc.js")

   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.absinthe-socket")
   (pom)
   (jar)
   (validate-checksums)))
