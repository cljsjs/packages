(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.5.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/filestack
      :version     +version+
      :description "Filestack is a client side file upload API & CDN"
      :scm         {:url "https://github.com/filepicker/filepicker-js"}
      :url         "https://www.filestack.com/docs/"})

(deftask package []
  (comp
   (download :url (str "http://static.filestackapi.com/filestack-js/" +lib-version+ "/filestack.min.js"))
   (sift :move {#"^filestack\.min\.js$" "cljsjs/filestack/development/filestack.inc.js"})
   (sift :include #{#"^cljsjs"})
   (minify :in "cljsjs/filestack/development/filestack.inc.js"
           :out "cljsjs/filestack/production/filestack.min.inc.js")
   (deps-cljs :name "cljsjs.filestack")
   (pom)
   (jar)
   (validate-checksums)))
