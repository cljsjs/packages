(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.11")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 push {:ensure-clean false}
 pom  {:project     'cljsjs/complex
       :version     +version+
       :description "A well tested JavaScript library to work with complex number arithmetic in JavaScript."
       :url         "https://github.com/infusion/Complex.js"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (format "https://github.com/infusion/Complex.js/archive/v%s.zip" +lib-version+)
             :unzip true)
   (sift :move {#"^Complex.js-[^\/]*/complex\.js" "cljsjs/complex/development/complex.inc.js"})
   (minify    :in  "cljsjs/complex/development/complex.inc.js"
              :out "cljsjs/complex/production/complex.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.complex")
   (pom)
   (jar)
   (validate-checksums)))
