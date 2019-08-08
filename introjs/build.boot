(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.4.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/introjs
      :version     +version+
      :description "Step-by-step guide and feature introduction"
      :url         "http://introjs.com/"
      :scm         {:url "https://github.com/usablica/intro.js"}
      :license     {"GNU AGPLv3" "https://www.gnu.org/licenses/agpl-3.0.en.html"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/usablica/intro.js/archive/v" +lib-version+ ".zip")
             :unzip true)
   (sift :move {#"intro.js-[^/]*/intro.js"                 "cljsjs/introjs/development/introjs.inc.js"
                #"intro.js-[^/]*/introjs.css"              "cljsjs/introjs/development/introjs.inc.css"
                #"intro.js-[^/]*/minified/intro.min.js"    "cljsjs/introjs/production/introjs.min.inc.js"
                #"intro.js-[^/]*/minified/introjs.min.css" "cljsjs/introjs/production/introjs.min.inc.css"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.introjs")
   (pom)
   (jar)))
