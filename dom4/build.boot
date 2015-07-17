(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.11" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.4.5")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/dom4
       :version     +version+
       :description "A DOM4 polyfill for parentNodes/childNodes entries"
       :url         "https://github.com/WebReflection/dom4"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/dom4/" +lib-version+ "/dom4.js"))
    (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/dom4/" +lib-version+ "/dom4.max.js"))
    (sift :move {#"dom4.max.js" "cljsjs/development/dom4.inc.js"
                 #"dom4.js" "cljsjs/production/dom4.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.dom4")))
