(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.0.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/skel
       :version     +version+
       :description "A lightweight responsive framework for the www"
       :url         "http://skel.io"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://github.com/ajlkn/skel/blob/master/LICENSE"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/ajlkn/skel/archive/v" +lib-version+ ".zip")
              :checksum "468BF568614B27BB9FB08A56A94A70ED"
              :unzip true)
    (sift :move {
      ;; Development JS
      #"skel-([\d\.]*)/src/skel.js" "cljsjs/development/skel.inc.js"
      #"skel-([\d\.]*)/src/skel-layout.js" "cljsjs/development/skel-layout.inc.js"
      #"skel-([\d\.]*)/src/skel-viewport.js" "cljsjs/development/skel-viewport.inc.js"
      ;; Production JS
      #"skel-([\d\.]*)/dist/skel.min.js" "cljsjs/production/skel.inc.js"
      #"skel-([\d\.]*)/dist/skel-layout.min.js" "cljsjs/production/skel-layout.inc.js"
      #"skel-([\d\.]*)/dist/skel-viewport.min.js" "cljsjs/production/skel-viewport.inc.js"
      ;; Development CSS
      #"skel-([\d\.]*)/src/_skel.scss" "cljsjs/development/_skel.scss"
      ;; Production CSS
      #"skel-([\d\.]*)/dist/_skel.scss" "cljsjs/production/_skel.scss"
      })
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.skel")
    (pom)
    (jar)))
