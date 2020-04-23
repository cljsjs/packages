(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.7.4")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/snabbdom
       :version     +version+
       :url         "https://github.com/snabbdom/snabbdom"
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/snabbdom/snabbdom/archive/v" +lib-version+ ".zip")
             :unzip true)
   (sift :move {#"^snabbdom-([\d\.]*)/dist/snabbdom.js"     "cljsjs/snabbdom/development/snabbdom.inc.js"
                #"^snabbdom-([\d\.]*)/dist/snabbdom.min.js" "cljsjs/snabbdom/production/snabbdom.min.inc.js"
                #"^snabbdom-([\d\.]*)/dist/snabbdom-attributes.js"     "cljsjs/snabbdom/development/snabbdom-attributes.inc.js"
                #"^snabbdom-([\d\.]*)/dist/snabbdom-attributes.min.js" "cljsjs/snabbdom/production/snabbdom-attributes.min.inc.js"
                #"^snabbdom-([\d\.]*)/dist/snabbdom-class.js"     "cljsjs/snabbdom/development/snabbdom-class.inc.js"
                #"^snabbdom-([\d\.]*)/dist/snabbdom-class.min.js" "cljsjs/snabbdom/production/snabbdom-class.min.inc.js"
                #"^snabbdom-([\d\.]*)/dist/snabbdom-eventlisteners.js"     "cljsjs/snabbdom/development/snabbdom-eventlisteners.inc.js"
                #"^snabbdom-([\d\.]*)/dist/snabbdom-eventlisteners.min.js" "cljsjs/snabbdom/production/snabbdom-eventlisteners.min.inc.js"
                #"^snabbdom-([\d\.]*)/dist/snabbdom-props.js"     "cljsjs/snabbdom/development/snabbdom-props.inc.js"
                #"^snabbdom-([\d\.]*)/dist/snabbdom-props.min.js" "cljsjs/snabbdom/production/snabbdom-props.min.inc.js"
                #"^snabbdom-([\d\.]*)/dist/snabbdom-style.js"     "cljsjs/snabbdom/development/snabbdom-style.inc.js"
                #"^snabbdom-([\d\.]*)/dist/snabbdom-style.min.js" "cljsjs/snabbdom/production/snabbdom-style.min.inc.js"
                })
   (sift :include #{#"^cljsjs" #"^deps.cljs"})
   (pom)
   (jar)
   (validate)))
