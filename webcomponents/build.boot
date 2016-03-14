(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]
                 [cljsjs/jquery "2.1.4-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.7.21")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/webcomponents
       :version     +version+
       :description "jQuery plugin that types."
       :url         "https://github.com/webcomponents/webcomponentsjs"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
   (download :url      (format "https://github.com/webcomponents/webcomponentsjs/archive/v%s.zip" +lib-version+)
             :checksum "B721C751CE0E1D926162603752E51061"
             :unzip    true)
   (sift :move {(re-pattern (str "^webcomponentsjs-" +lib-version+ "/webcomponents.js$"))  "cljsjs/webcomponents/development/webcomponents.inc.js"
                (re-pattern (str "^webcomponentsjs-" +lib-version+ "/webcomponents.min.js$"))  "cljsjs/webcomponents/development/webcomponents.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.webcomponents")
   (pom)
   (jar)))
