(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.6.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/autolayout
       :version     +version+
       :description "Apple's Auto Layout and Visual Format Language for javascript (using cassowary constraints)"
       :url         "http://ijzerenhein.github.io/autolayout.js/"
       :scm         {:url "https://github.com/IjzerenHein/autolayout.js"}
       :license     {"MIT" "https://github.com/IjzerenHein/autolayout.js/blob/master/LICENSE"}})

(deftask package []
         (comp
           (download :url (format "https://github.com/IjzerenHein/autolayout.js/archive/v%s.zip" +lib-version+)
                     :unzip true)
           (sift :move {#"^autolayout.*\/dist\/autolayout.js" "cljsjs/autolayout/development/autolayout.inc.js"
                        #"^autolayout.*\/dist\/autolayout.min.js" "cljsjs/autolayout/production/autolayout.min.inc.js"})
           (sift :include #{#"^cljsjs"})
           (show :fileset true)
           (deps-cljs :name "cljsjs.autolayout")
           (pom)
           (jar)))
