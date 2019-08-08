(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.4.3")
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
   (download :url (format "https://github.com/getsentry/sentry-javascript/releases/download/%s/sentry-browser-%s.tgz" +lib-version+ +lib-version+)
             :decompress true
             :compression-format "gz"
             :archive-format "tar")
   (sift :move {#"package/build/bundle\.js"
                "cljsjs/sentry-browser/development/sentry-browser.inc.js"
                #"package/build/bundle\.min\.js"
                "cljsjs/sentry-browser/production/sentry-browser.min.inc.js" })
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.sentry-browser")
   (pom)
   (jar)
   (validate)))
