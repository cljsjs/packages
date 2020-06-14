(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "6.0.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/fuse
      :version     +version+
      :description "Lightweight fuzzy-search, in JavaScript http://fusejs.io/"
      :url         "http://fusejs.io/"
      :scm         {:url "https://github.com/krisk/Fuse"}
      :license     {"Apache 2.0" "https://www.apache.org/licenses/LICENSE-2.0.html"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/krisk/Fuse/archive/v" +lib-version+ ".zip")
             :checksum "a8d52ab8d74dc599fa74521b4714cd02"
             :unzip true)
   (sift :move {#"^Fuse-(.*)/dist/fuse.js" "cljsjs/fuse/development/fuse.inc.js"
                #"^Fuse-(.*)/dist/fuse.min.js" "cljsjs/fuse/production/fuse.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.fuse")
   (pom)
   (jar)))
