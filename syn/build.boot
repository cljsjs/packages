(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.1.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/syn
        :version     +version+
        :description "Standalone Synthetic Event Library"
        :url         "https://github.com/bitovi/syn"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/bitovi/syn/archive/v%s.zip" +lib-version+)
              :checksum "04973C3BF25A644E20F6FD43D95E77EC"
              :unzip true)
    (sift :move {#"^syn-.*/dist/syn.js" "cljsjs/development/syn.inc.js"})
    (sift :move {#"^syn-.*/dist/syn.js" "cljsjs/production/syn.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.syn")
    (pom)
    (jar))) 
