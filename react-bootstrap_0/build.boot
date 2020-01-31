(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces "0.1.13" :scope "test"]
                  [cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                  [cljsjs/react "16.4.2-0"]
                  [cljsjs/react-dom "16.4.2-0"]
                  [cljsjs/bootstrap "3.3.6-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.32.4")
(def +version+ (str +lib-version+ "-0"))


(task-options!
 pom  {:project     'cljsjs/react-bootstrap
       :version     +version+
       :description "The most popular front-end framework, rebuilt for React. Bootstrap V3 branch."
       :url         "https://react-bootstrap.github.io/index.html"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://raw.githubusercontent.com/react-bootstrap/react-bootstrap/bs3-dev/LICENSE"}})

(deftask package []
  (comp
    (download :url (format "https://unpkg.com/react-bootstrap@%s/dist/react-bootstrap.js" +lib-version+))
    (download :url (format "https://unpkg.com/react-bootstrap@%s/dist/react-bootstrap.min.js" +lib-version+))
    (sift :move {#"react-bootstrap\.js"
                 "cljsjs/react-bootstrap/development/react-bootstrap.inc.js"
                 #"react-bootstrap\.min\.js"
                 "cljsjs/react-bootstrap/production/react-bootstrap.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-bootstrap"
               :requires ["cljsjs.react.dom"])
    (pom)
    (jar)
    (validate)))
