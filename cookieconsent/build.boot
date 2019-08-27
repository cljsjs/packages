(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[boot.task.built-in :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.1.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/cookieconsent
       :version     +version+
       :description "Cookie Consent by Insites"
       :url         "https://cookieconsent.insites.com/"
       :scm         {:url "https://github.com/insites/cookieconsent"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/insites/cookieconsent/archive/" +lib-version+ ".zip")
             :unzip true)

   (sift :move {#"^cookieconsent-.*/build/cookieconsent.min.css"
                "cljsjs/cookieconsent/common/cookieconsent.min.css"

                #"^cookieconsent-.*/src/cookieconsent.js"
                "cljsjs/cookieconsent/development/cookieconsent.inc.js"

                #"^cookieconsent-.*/build/cookieconsent.min.js"
                "cljsjs/cookieconsent/production/cookieconsent.min.inc.js"})

   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.cookieconsent")
   (pom)
   (jar)
   (validate)))
