(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.3.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/sizzle
        :version     +version+
        :description "A pure-JavaScript CSS selector engine designed to be easily dropped in to a host library."
        :url         "https://github.com/jquery/sizzle"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/jquery/sizzle/archive/%s.zip" +lib-version+)
              :checksum "6FC37ABB2F63288A62C049DFD50D56FE"
              :unzip true)
    (sift :move {#"^sizzle-.*/dist/sizzle.js" "cljsjs/development/sizzle.inc.js"})
    (sift :move {#"^sizzle-.*/dist/sizzle.min.js" "cljsjs/production/sizzle.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.sizzle"))) 
