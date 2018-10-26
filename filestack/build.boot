(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.9.9")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/filestack
      :version     +version+
      :description "Filestack is a client side file upload API & CDN"
      :scm         {:url "https://github.com/filepicker/filepicker-js"}
      :url         "https://www.filestack.com/docs/"})

(deftask package []
  (comp
   (download :url (str "http://static.filestackapi.com/v3/filestack-" +lib-version+ ".js")
             :checksum "0C5D4282C4136892883EB702C00452B8")
   (sift :move {#"^filestack-\d+\.\d+\.\d+\.js$" "cljsjs/filestack/development/filestack.inc.js"})
   (target)
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.filestack")
   (pom)
   (jar)))
