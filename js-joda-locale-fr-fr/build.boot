(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.1.1")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  push {:repo "clojars"}
  pom  {:project     'io.github.cljsjs/js-joda-locale-fr-fr
        :version     +version+
        :description "prebuilt fr-fr locale addon for js-joda"
        :url         "https://js-joda.github.io/js-joda/js-joda-locale"
        :scm         {:url "https://github.com/cljsjs/packages"}
        :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (format "https://registry.npmjs.org/@js-joda/locale_fr-fr/-/locale_fr-fr-%s.tgz" +lib-version+)
      :decompress true
      :archive-format "tar"
      :compression-format "gz")
    (sift :move {#"^package/dist/index\.js$" "cljsjs/js-joda-locale-fr-fr/development/js-joda-locale-fr-fr.inc.js"})

    (minify :in  "cljsjs/js-joda-locale-fr-fr/development/js-joda-locale-fr-fr.inc.js"
      :out "cljsjs/js-joda-locale-fr-fr/production/js-joda-locale-fr-fr.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs
      :foreign-libs [{:file #"js-joda-locale-fr-fr.inc.js"
                      :file-min #"js-joda-locale-fr-fr.min.inc.js"
                      :provides ["@js-joda/locale_fr-fr"]
                      :requires ["@js-joda/core"]
                      :global-exports '{"@js-joda/locale_fr-fr" JSJodaLocale}}]
      )
    (pom)
    (jar)))
