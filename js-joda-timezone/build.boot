(set-env!
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.17.2")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'io.github.cljsjs/js-joda-timezone
       :version     +version+
       :description "timezone extensions for js-joda"
       :url         "https://js-joda.github.io/js-joda/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://registry.npmjs.org/@js-joda/timezone/-/timezone-%s.tgz" +lib-version+)
             :decompress true
             :compression-format "gz"
             :archive-format "tar")

   (sift :move {#"package/dist/js-joda-timezone.js$" "cljsjs/js-joda-timezone/development/js-joda-timezone.inc.js"
                #"package/dist/js-joda-timezone.min.js$" "cljsjs/js-joda-timezone/production/js-joda-timezone.min.inc.js"}
         :include #{#"^cljsjs"})
   (deps-cljs
    :no-externs true
    :provides ["@js-joda/timezone"]
    :requires ["@js-joda/core"])
   (pom)
   (show :fileset true)
   (jar)
   (validate)))
