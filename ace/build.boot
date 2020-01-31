(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.4.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/ace
        :version     +version+
        :url         "https://ace.c9.io/"
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/ajaxorg/ace-builds/archive/v" +lib-version+ ".zip")
             :unzip true)
   (sift :move {#"^ace-builds-([\d\.]*)/src/ace.js"     "cljsjs/ace/development/ace.inc.js"
                #"^ace-builds-([\d\.]*)/src-min/ace.js" "cljsjs/ace/production/ace.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.ace")
   (pom)
   (jar)))
