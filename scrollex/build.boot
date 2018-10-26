(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]
                 [cljsjs/jquery "2.2.2-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.2.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/scrollex
       :version     +version+
       :description "Nifty scroll events for jQuery."
       :url         "https://github.com/ajlkn/jquery.scrollex"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url      (format "https://github.com/ajlkn/jquery.scrollex/archive/v%s.zip" +lib-version+)
             :checksum "FAD853E6F15194A40B24562D2A71DB5B"
             :unzip    true)
   (sift :move {(re-pattern (str "^jquery.scrollex-" +lib-version+ "/jquery.scrollex.js$"))  "cljsjs/scrollex/development/jquery.scrollex.inc.js"
                (re-pattern (str "^jquery.scrollex-" +lib-version+ "/jquery.scrollex.min.js$"))  "cljsjs/scrollex/production/jquery.scrollex.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.scrollex")
   (pom)
   (jar)))
