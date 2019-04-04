(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                  [cljsjs/react "16.8.3-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

  (def +lib-version+ "5.0.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project 'cljsjs/react-router-dom
       :version +version+
       :description "Declarative routing for React"
       :url "https://github.com/ReactTraining/react-router-dom"
       :scm {:url "https://github.com/cljsjs/packages"}
       :license {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
         (comp
           (download :url (str "https://unpkg.com/react-router-dom@" +lib-version+ "/umd/react-router-dom.js"))
           (download :url (str "https://unpkg.com/react-router-dom@" +lib-version+ "/umd/react-router-dom.min.js"))

           (sift :move {#"react-router-dom.js"
                        "cljsjs/react-router/development/react-router-dom.inc.js"
                        #"react-router-dom.min.js"
                        "cljsjs/react-router/production/react-router-dom.min.inc.js"})
           (sift :include #{#"^cljsjs"})
           (deps-cljs :name "cljsjs.react-router-dom"
                      :requires ["cljsjs.react"])
           (pom)
           (jar)
           (validate)))
