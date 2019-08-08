(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.8")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/url-template
      :version     +version+
      :description "A JavaScript URI template implementation"
      :url         "https://github.com/bramstein/url-template"
      :scm         {:url "https://github.com/bramstein/url-template"}
      :license     {"BSD" "https://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
    (download  :url      (format "https://github.com/bramstein/url-template/archive/v%s.zip" +lib-version+)
               :checksum "AE366E4CB972CE228A96D44B82E5189E"
               :unzip    true)
    (sift      :move     {#"^url-template(.*)/lib/url-template.js"
                          "cljsjs/url-template/development/url-template.inc.js"})
    (minify    :in "cljsjs/url-template/development/url-template.inc.js"
               :out "cljsjs/url-template/production/url-template.min.inc.js")
    (sift      :include  #{#"^cljsjs"})
    (deps-cljs :name     "cljsjs.url-template")
    (pom)
    (jar)))
