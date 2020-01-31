(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.4.0")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  pom {:project     'cljsjs/zxcvbn
       :version     +version+
       :description "zxcvbn is a password strength estimator inspired by password crackers."
       :url         "https://github.com/dropbox/zxcvbn"
       :scm         {:url "https://github.com/SMX-LTD/cljsjs-packages"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download
      ;; todo remove the v prefix after https://github.com/dropbox/zxcvbn/issues/148#issuecomment-249992432
      :url (str "https://github.com/dropbox/zxcvbn/archive/v" +lib-version+ ".zip")
      :unzip true)

    ;; boot will default to production if development version is missing which
    ;; is okay in our case because zxcvbn is already minified
    (sift :move {#"zxcvbn-.*/dist/zxcvbn.js$" "cljsjs/zxcvbn/production/zxcvbn.inc.js"})
    (sift :move {#"zxcvbn-.*/dist/zxcvbn.js.map$" "cljsjs/zxcvbn/production/zxcvbn.inc.js.map"})

    (replace-content
      :in "cljsjs/zxcvbn/production/zxcvbn.inc.js"
      :match #"\/\/\# sourceMappingURL=zxcvbn\.js\.map$"
      :value "//# sourceMappingURL=zxcvbn.inc.js.map")

    (sift :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.zxcvbn")

    (pom)
    (jar)))
