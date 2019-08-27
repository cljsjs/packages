(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]])

(require
  '[cljsjs.boot-cljsjs.packaging :refer :all]
  '[boot.core :as boot])

(def +lib-version+ "0.4.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/smoothscroll-polyfill
        :version     +version+
        :description "Polyfill for the Scroll Behavior specification"
        :url         "http://iamdustan.com/smoothscroll/"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/iamdustan/smoothscroll"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/iamdustan/smoothscroll/archive/v" +lib-version+ ".zip")
      :checksum "5A41A5F1E95E5219C0F5347FF64594CC"
      :unzip true)
    (sift :move {#"^smoothscroll-.+/dist/smoothscroll.js$" "cljsjs/smoothscroll-polyfill/development/smoothscroll-polyfill.inc.js"})
    (minify
      :in   "cljsjs/smoothscroll-polyfill/development/smoothscroll-polyfill.inc.js"
      :out  "cljsjs/smoothscroll-polyfill/production/smoothscroll-polyfill.min.inc.js"
      :lang :ecmascript5)
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.smoothscroll-polyfill")
    (pom)
    (jar)))
