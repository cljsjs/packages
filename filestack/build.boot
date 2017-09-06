(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.7.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.6.3")
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
             :checksum "6A2BBF6B6799E044C1EC0B5D65B99385")
   (sift :move {#"^filestack-\d+\.\d+\.\d+\.js$" "cljsjs/filestack/development/filestack.inc.js"})
   (target)
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.filestack")
   (pom)
   (jar)))
