(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                  [cljsjs/react "16.13.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

  (def +lib-version+ "0.19.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/scheduler
       :version     +version+
       :description "This is a package for cooperative scheduling in a browser environment."
       :url         "http://facebook.github.io/react/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(defn url [name env]
  (format "https://unpkg.com/browse/scheduler@%s/umd/scheduler%s.%s.js" +lib-version+ (if name (str "-" name) "") env))


(deftask package []
  (comp
    (download :url (url nil "development") :target "cljsjs/scheduler/scheduler.development.js")
    (download :url (url nil "production.min") :target "cljsjs/scheduler/scheduler.production.min.js")
    (download :url (url "unstable_mock" "development") :target "cljsjs/scheduler/scheduler-unstable_mock.development.js")
    (download :url (url "unstable_mock" "production.min") :target "cljsjs/scheduler/scheduler-unstable_mock.production.min.js")
    (download :url (url "tracing" "development") :target "cljsjs/scheduler/scheduler-tracing.development.js")
    (download :url (url "tracing" "production.min") :target "cljsjs/scheduler/scheduler-tracing.production.min.js")
    (deps-cljs :foreign-libs [{:file #"scheduler.production.min.js"
                               :file-min #"scheduler.development.js"
                               :requires []
                               :provides ["scheduler" "cljsjs.scheduler"]
                               :global-exports {"scheduler" "Scheduler"}}
                              {:file #"scheduler-unstable_mock.production.min.js"
                               :file-min #"scheduler-unstable_mock.development.js"
                               :requires []
                               :provides ["scheduler" "cljsjs.scheduler"]
                               :global-exports {"scheduler/unstable_mock" "SchedulerMock"}}
                              {:file #"scheduler-tracing.production.min.js"
                               :file-min #"scheduler-tracing.development.js"
                               :requires []
                               :provides ["scheduler" "cljsjs.scheduler"]
                               :global-exports {"scheduler/profiling" "SchedulerTracing"}}]
               :externs [#"scheduler\.ext\.js"])
    (pom)
    (jar)
    (validate-libs)
    (validate-checksums :patterns [#"^cljsjs/scheduler/.*\.js$"])))
