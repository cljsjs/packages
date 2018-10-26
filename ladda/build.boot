(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                 [cljsjs/spin "2.3.2-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/ladda
      :version     +version+
      :description "Buttons with built-in loading indicators."
      :url         "http://lab.hakim.se/ladda/"
      :scm         {:url "https://github.com/hakimel/Ladda"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/hakimel/Ladda/archive/" +lib-version+ ".zip")
             :checksum "e7a8484366fba689e336d79cfd64e0fe"
             :unzip true)
   (sift :move {#"^Ladda-(.*)/js/ladda.js" "cljsjs/ladda/development/ladda.inc.js"
                #"^Ladda-(.*)/dist/ladda.min.js" "cljsjs/ladda/production/ladda.min.inc.js"
                #"^Ladda-(.*)/dist/ladda.min.css" "cljsjs/ladda/common/ladda.min.inc.css"
                #"^Ladda-(.*)/dist/ladda-themeless.min.css" "cljsjs/ladda/common/ladda-themeless.min.inc.css"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.ladda"
              :requires ["cljsjs.spin"])
   (pom)
   (jar)))
