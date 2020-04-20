(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.12.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/js-joda
       :version     +version+
       :description "A date and time library for javascript"
       :url         "https://js-joda.github.io/js-joda/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp 
    (download :url (format "https://github.com/js-joda/js-joda/archive/@js-joda/core@%s.zip" +lib-version+)
                :unzip true)
    (sift :move {#"^js-joda--js-joda-core-([\d\.]+)/packages/core/dist/js-joda.min.js$" "cljsjs/js-joda-core/js-joda.min.js"})
    
    (sift :move {#"^js-joda--js-joda-core-([\d\.]+)/packages/core/dist/js-joda.js$" "cljsjs/js-joda-core/js-joda.inc.js"})
    
    (sift :include #{#"^cljsjs"})
    (deps-cljs
      :foreign-libs [{:file #"js-joda.inc.js"
                      :file-min #"js-joda.min.js"
                      :provides ["@js-joda/core"]
                      :requires []
                      :global-exports '{"@js-joda/core" JSJoda}}]
      :externs [#"js-joda.ext.js"])
    (pom)
    (show :fileset true)
    (jar)))
