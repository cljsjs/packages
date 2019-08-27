(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.2.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/flyd
       :version     +version+
       :description "The modular, KISS, functional reactive programming library for JavaScript."
       :url         "https://github.com/paldepind/flyd"
       :scm         {:url "https://github.com/paldepind/flyd"}
       :license     {"MIT" "https://github.com/paldepind/flyd/blob/master/LICENSE"}})

(deftask package []
         (comp
           (download :url (format "https://github.com/paldepind/flyd/archive/v%s.zip" +lib-version+)
                     :checksum "eb3e952c894093d0380e629c95cb1e2e"
                     :unzip true)
           (sift :move {#"^flyd-[^/]*/flyd\.js$" "cljsjs/flyd/development/flyd.inc.js"
                        #"^flyd-[^/]*/flyd\.js$" "cljsjs/flyd/production/flyd.min.inc.js"})
           (sift :include #{#"^cljsjs"})
           (deps-cljs :name "cljsjs.flyd")
           (pom)
           (jar)))
