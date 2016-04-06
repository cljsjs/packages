(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.1.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/enquire
       :version     +version+
       :description " enquire.js is a lightweight, pure JavaScript library for responding to CSS media queries."
       :url         "http://wicky.nillia.ms/enquire.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://github.com/WickyNilliams/enquire.js/archive/v%s.zip" +lib-version+)
             :checksum "d4817abff3cff26befb35736cb2e49f6"
             :unzip true)
   (sift :move {#"^enquire\.[^\/]*/dist/enquire.js" "cljsjs/enquire/development/enquire.inc.js"
                #"^enquire\.[^\/]*/dist/enquire.min.js" "cljsjs/enquire/production/enquire.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.enquire")
   (pom)
   (jar)))
