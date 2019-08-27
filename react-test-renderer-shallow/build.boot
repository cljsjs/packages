(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]
                  [cljsjs/react "16.4.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

  (def +lib-version+ "16.4.1")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/react-test-renderer-shallow
       :version     +version+
       :description "The React shallow renderer"
       :url         "http://facebook.github.io/react/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (format "https://unpkg.com/react-test-renderer@%s/umd/react-test-renderer-shallow.development.js" +lib-version+)
              :target "cljsjs/react-test-renderer-shallow/development/react-test-renderer-shallow.inc.js")
    (download :url (format "https://unpkg.com/react-test-renderer@%s/umd/react-test-renderer-shallow.production.min.js" +lib-version+)
              :target "cljsjs/react-test-renderer-shallow/production/react-test-renderer-shallow.min.inc.js")
    (deps-cljs :provides ["react-test-renderer/shallow" "cljsjs.react.test-renderer.shallow"]
               :requires ["react"]
               :global-exports '{react-test-renderer-shallow ReactShallowRenderer})
    (pom)
    (jar)
    (validate)))
