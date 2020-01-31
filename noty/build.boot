(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.1.4")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/noty
      :version     +version+
      :description "Dependency-free notification library that makes it easy to create alert - success - error - warning - information - confirmation messages as an alternative the standard alert dialog."
      :url         "https://ned.im/noty/#/"
      :scm         {:url "https://github.com/needim/noty"}
      :license     {"MIT License" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/needim/noty/archive/v" +lib-version+ ".zip")
             :unzip true)
   (sift :move {#"^noty-[^/]*/lib/noty.js"     "cljsjs/noty/development/noty.inc.js"
                #"^noty-[^/]*/lib/noty.min.js" "cljsjs/noty/production/noty.min.inc.js"})
   (sift :include #{#"^cljsjs" #"^deps.cljs"})
   (deps-cljs :name "cljsjs.noty")
   (pom)
   (jar)))
