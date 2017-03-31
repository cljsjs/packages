(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.6.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.1.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/xregexp
       :version     +version+
       :description "Extended JavaScript regular expressions"
       :url         "https://github.com/slevithan/xregexp"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})


(deftask package []
  (comp
   (download :url "https://raw.githubusercontent.com/slevithan/xregexp/37413619ea9f03638bfa92e038e4b4c15645d446/src/xregexp.js"
             :checksum "1df474f383fedf216d99743f6d304d17")

   (replace-content :in "xregexp.js" :out "xregexp.inc.js"
                    :match #"module.exports = .*;"
                    :value "")

   (sift :move {#"^xregexp.inc.js$" "cljsjs/xregexp/development/xregexp.inc.js"})

   (minify :in  "cljsjs/xregexp/development/xregexp.inc.js"
           :out "cljsjs/xregexp/production/xregexp.min.inc.js")

   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.xregexp")
   (pom)
   (jar)))
