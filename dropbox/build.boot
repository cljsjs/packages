(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.10.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/dropbox
       :version     +version+
       :description "Javascript client for Dropbox"
       :url         "https://github.com/dropbox/dropbox-js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Dropbox ToS" "https://www.dropbox.com/terms"}})

(deftask package []
  (comp
   (download :url (str "http://cdnjs.cloudflare.com/ajax/libs/dropbox.js/" +lib-version+ "/dropbox.js"))
   (download :url (str "http://cdnjs.cloudflare.com/ajax/libs/dropbox.js/" +lib-version+ "/dropbox.min.js"))
   (sift :move {#"^dropbox\.js" "cljsjs/dropbox/development/dropbox.inc.js"
                #"^dropbox\.min\.js" "cljsjs/dropbox/production/dropbox.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.dropbox")))
