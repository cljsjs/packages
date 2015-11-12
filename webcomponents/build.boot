(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.12" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.7.14")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/webcomponents
       :version     +version+
       :description "A suite of polyfills supporting the HTML Web Components specs"
       :url         "https://github.com/webcomponents/webcomponentsjs"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
    (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/webcomponentsjs/" +lib-version+ "/webcomponents.min.js"))
    (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/webcomponentsjs/" +lib-version+ "/webcomponents.js"))
    (sift :move {#"webcomponents.js" "cljsjs/development/webcomponents.inc.js"
                 #"webcomponents.min.js" "cljsjs/production/webcomponents.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :no-externs true :name "cljsjs.webcomponents")))
