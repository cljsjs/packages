(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.5")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/mdl-stepper
       :version     +version+
       :description ""
       :url         "https://ahlechandre.github.io/mdl-stepper"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (task-options! push {:ensure-branch nil})
  (comp
    (download :url (str "https://github.com/ahlechandre/mdl-stepper/archive/v" +lib-version+ ".zip")
              :checksum "C6BFF1CCBF15A5BCEE4AAEBD7B6EBF5C"
              :unzip true)
    (sift :move {(re-pattern (str "^mdl-stepper-" +lib-version+ "/stepper.js$"))        "cljsjs/mdl-stepper/development/stepper.inc.js"
                 (re-pattern (str "^mdl-stepper-" +lib-version+ "/stepper.css$"))        "cljsjs/mdl-stepper/development/stepper.inc.css"
                 (re-pattern (str "^mdl-stepper-" +lib-version+ "/stepper.min.js$"))   "cljsjs/mdl-stepper/production/stepper.min.inc.js"
                 (re-pattern (str "^mdl-stepper-" +lib-version+ "/stepper.min.css$")) "cljsjs/mdl-stepper/production/stepper.min.inc.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.mdl-stepper")
    (pom)
    (jar)))
