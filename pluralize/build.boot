(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.0.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/pluralize
      :version     +version+
      :description "Pluralize or singularize any word based on a count"
      :url         "https://github.com/blakeembrey/pluralize"
      :scm         {:url "https://github.com/blakeembrey/pluralize"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download  :url      (format "https://github.com/blakeembrey/pluralize/archive/v%s.zip" +lib-version+)
              :checksum "bed1a0e6deedaedb4f178c4989aeb68d"
              :unzip    true)
   (sift      :move     {#"^pluralize(.*)/pluralize.js"
                         "cljsjs/pluralize/development/pluralize.inc.js"})
    (minify :in "cljsjs/pluralize/development/pluralize.inc.js"
            :out "cljsjs/pluralize/production/pluralize.min.inc.js")
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.pluralize")
   (pom)
   (jar)))
