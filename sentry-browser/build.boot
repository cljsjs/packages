(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.17.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/sentry-browser
      :version     +version+
      :description "@sentry/browser: JavaScript client for Sentry https://getsentry.com"
      :url         "https://docs.getsentry.com/hosted/clients/javascript/"
      :scm         {:url "https://github.com/getsentry/sentry-javascript/tree/master/packages/browser"}
      :license     {"MIT" "https://github.com/getsentry/sentry-javascript/blob/master/packages/browser/LICENSE"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/@sentry/browser@%s/build/bundle.js" +lib-version+)
             :target "cljsjs/sentry-browser/development/sentry-browser.inc.js")
   (download :url (format "https://unpkg.com/@sentry/browser@%s/build/bundle.min.js" +lib-version+)
             :target "cljsjs/sentry-browser/production/sentry-browser.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :foreign-libs [{:file #"sentry-browser.inc.js"
                              :file-min #"sentry-browser.min.inc.js"
                              :provides ["@sentry/browser"
                                         "cljsjs.sentry-browser"]
                              ;; Requires cljs 1.10.439
                              :global-exports {"@sentry/browser" "Sentry"}}]
              :externs [#"sentry-browser.ext.js"])
   (pom)
   (jar)
   (validate)))
