(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.2.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/barn
        :version     +version+
        :description "Fast, atomic persistent storage layer on top of localStorage. Barn provides a Redis-like API"
        :url         "https://github.com/arokor/barn"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/arokor/barn/archive/" +lib-version+ ".zip")
              :checksum "91F780806FAA217F6615790D717258D4"
              :unzip true)
    (sift :move {(re-pattern (str "barn-" +lib-version+ "/dist/barn.js")) "cljsjs/development/barn.inc.js"
                 (re-pattern (str "barn-" +lib-version+ "/dist/barn.min.js")) "cljsjs/production/barn.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.barn")
    (pom)
    (jar)))
