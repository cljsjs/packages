(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.3.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/platform
      :version     +version+
      :description "A platform detection library"
      :url         "https://mths.be/platform"
      :scm         {:url "https://github.com/bestiejs/platform.js"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download  :url      (format "https://github.com/bestiejs/platform.js/archive/%s.zip" +lib-version+)
              :checksum "4c3b7e8dfb03de8b18f26f1d068d9baa"
              :unzip    true)
   (sift      :move     {#"^platform(.*)/platform.js"
                         "cljsjs/platform/development/platform.inc.js"})
    (minify :in "cljsjs/platform/development/platform.inc.js"
            :out "cljsjs/platform/production/platform.min.inc.js")
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.platform")
   (pom)
   (jar)))
