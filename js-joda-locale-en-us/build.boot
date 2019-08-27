(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  push {:repo "clojars"}
  pom  {:project     'cljsjs/js-joda-locale-en-us
        :version     +version+
        :description "prebuilt en-US locale addon for js-joda"
        :url         "https://js-joda.github.io/js-joda/js-joda-locale"
        :scm         {:url "https://github.com/cljsjs/packages"}
        :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (format "https://registry.npmjs.org/@js-joda/locale_en-us/-/locale_en-us-%s.tgz" +lib-version+)
      :decompress true
      :archive-format "tar"
      :compression-format "gz")
    (sift :move {#"^package/dist/index\.js$" "cljsjs/js-joda-locale-en-us/development/js-joda-locale-en-us.inc.js"})

    (minify :in  "cljsjs/js-joda-locale-en-us/development/js-joda-locale-en-us.inc.js"
      :out "cljsjs/js-joda-locale-en-us/production/js-joda-locale-en-us.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs
      :name "cljsjs.js-joda-locale-en-us")
    (pom)
    (jar)))
