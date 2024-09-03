(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.6.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'io.github.cljsjs/js-joda
       :version     +version+
       :description "A date and time library for javascript"
       :url         "https://js-joda.github.io/js-joda/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://registry.npmjs.org/@js-joda/core/-/core-%s.tgz" +lib-version+)
             :decompress true
             :compression-format "gz"
             :archive-format "tar")
   (sift :move {#"package/dist/js-joda.js$" "cljsjs/js-joda-core/development/js-joda.inc.js"
                #"package/dist/js-joda.min.js$" "cljsjs/js-joda-core/production/js-joda.min.js"}
         :include #{#"^cljsjs"})
   (deps-cljs
    :foreign-libs [{:file #"cljsjs/js-joda-core/production/js-joda.min.js"
                    :provides ["@js-joda/core"]
                    :global-exports '{"@js-joda/core" JSJoda}}]
    :externs [#"cljsjs/js-joda/common/js-joda.ext.js"])
   (pom)
   (show :fileset true)
   (jar)))
