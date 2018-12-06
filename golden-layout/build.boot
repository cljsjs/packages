(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                  [cljsjs/jquery    "1.9.1-0"] ])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.5.9")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/golden-layout
        :version     +version+
        :url         "https://golden-layout.com/"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/golden-layout/golden-layout/archive/v" +lib-version+ ".zip")
             :unzip true)
   (sift :move {#"^golden-layout-([\d\.]*)/dist/goldenlayout.js" "cljsjs/golden-layout/development/goldenlayout.inc.js"
                #"^golden-layout-([\d\.]*)/dist/goldenlayout.min.js" "cljsjs/golden-layout/production/goldenlayout.min.inc.js"
                
                #"^golden-layout-([\d\.]*)/src/css/goldenlayout-base.css" "cljsjs/golden-layout/development/goldenlayout-base.inc.css"
                #"^golden-layout-([\d\.]*)/src/css/goldenlayout-base.css" "cljsjs/golden-layout/production/goldenlayout-base.inc.css"
                
                #"^golden-layout-([\d\.]*)/src/css/goldenlayout-dark-theme.css" "cljsjs/golden-layout/development/goldenlayout-dark-theme.inc.css"
                #"^golden-layout-([\d\.]*)/src/css/goldenlayout-dark-theme.css" "cljsjs/golden-layout/production/goldenlayout-dark-theme.inc.css"
                
                #"^golden-layout-([\d\.]*)/src/css/goldenlayout-light-theme.css" "cljsjs/golden-layout/development/goldenlayout-light-theme.inc.css"
                #"^golden-layout-([\d\.]*)/src/css/goldenlayout-light-theme.css" "cljsjs/golden-layout/production/goldenlayout-light-theme.inc.css"})
   (deps-cljs :name "cljsjs.golden-layout" :requires ["cljsjs.jquery"])
   (sift :include #{#"^cljsjs" #"^deps\.cljs$"})
   (pom)
   (jar)))
