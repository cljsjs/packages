(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.4")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-lifecycles-compat
       :version     +version+
       :description "Backwards compatibility polyfill for React class components"
       :url         "http://facebook.github.io/react/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
    (download :url (format "https://unpkg.com/react-lifecycles-compat@%s/react-lifecycles-compat.js" +lib-version+)
              :target "cljsjs/react-lifecycles-compat/development/react-lifecycles-compat.inc.js")
    (download :url (format "https://unpkg.com/react-lifecycles-compat@%s/react-lifecycles-compat.min.js" +lib-version+)
              :target "cljsjs/react-lifecycles-compat/production/react-lifecycles-compat.min.inc.js")
    (deps-cljs :provides ["react-lifecycles-compat"]
               :global-exports '{react-lifecycles-compat reactLifecyclesCompat})
    (pom)
    (jar)
    (validate)))
