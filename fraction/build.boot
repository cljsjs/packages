(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.0.12")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 push {:ensure-clean false}
 pom  {:project     'cljsjs/fraction
       :version     +version+
       :description "Fraction is a rational number library written in JavaScript."
       :url         "https://github.com/infusion/Fraction.js"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (format "https://github.com/infusion/Fraction.js/archive/v%s.zip" +lib-version+)
             :unzip true)
   (sift :move {#"^Fraction.js-[^\/]*/fraction\.js" "cljsjs/fraction/development/fraction.inc.js"})
   (minify    :in  "cljsjs/fraction/development/fraction.inc.js"
              :out "cljsjs/fraction/production/fraction.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.fraction")
   (pom)
   (jar)
   (validate-checksums)))
