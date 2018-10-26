(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.0.1")
(def +version+ (str +lib-version+ "-1"))

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
              :checksum "D03E4D90221C799E703FF9653CBCC112"
              :unzip true)
    (sift :move {
      ;; Development JS
      #"skel-([\d\.]*)/src/skel.js" "cljsjs/skel/development/skel.inc.js"
      #"skel-([\d\.]*)/src/skel-layout.js" "cljsjs/skel/development/skel-layout.inc.js"
      #"skel-([\d\.]*)/src/skel-viewport.js" "cljsjs/skel/development/skel-viewport.inc.js"
      ;; Production JS
      #"skel-([\d\.]*)/dist/skel.min.js" "cljsjs/skel/production/skel.min.inc.js"
      #"skel-([\d\.]*)/dist/skel-layout.min.js" "cljsjs/skel/production/skel-layout.min.inc.js"
      #"skel-([\d\.]*)/dist/skel-viewport.min.js" "cljsjs/skel/production/skel-viewport.min.inc.js"
      ;; Development CSS
      #"skel-([\d\.]*)/src/_skel.scss" "cljsjs/skel/development/_skel.scss"
      ;; Production CSS
      #"skel-([\d\.]*)/dist/_skel.scss" "cljsjs/skel/production/_skel.scss"
      })
    (sift :include #{#"^cljsjs" #"^deps.cljs"})
    (pom)
    (jar)))
