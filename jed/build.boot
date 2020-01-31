(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/jed
      :version     +version+
      :description "Gettext style i18n for modern JavaScript apps"
      :url         "https://slexaxton.github.io/Jed/"
      :scm         {:url "https://github.com/SlexAxton/Jed"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download  :url      (format "https://github.com/SlexAxton/Jed/archive/%s.zip" +lib-version+)
              :checksum "603D48E887FB6A1FE51A677B1631A3BA"
              :unzip    true)
   (sift      :move     {#"^Jed.*/jed.js" "cljsjs/jed/development/jed.inc.js"})
   (minify    :in       "cljsjs/jed/development/jed.inc.js"
              :out      "cljsjs/jed/production/jed.min.inc.js")
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.jed")
   (pom)
   (jar)))
