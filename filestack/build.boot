(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.4.10")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/filestack
      :version     +version+
      :description "Filestack is a client side file upload API & CDN"
      :scm         {:url "https://github.com/filepicker/filepicker-js"}
      :url         "https://www.filestack.com/docs/"})

(deftask package []
  (comp
   (download :url (str "https://api.filestackapi.com/filestack-" +lib-version+ ".min.js")
             :checksum "6F242D61B55D20BC4F9DB053D01C5A1C")
   (download :url (str "https://api.filestackapi.com/filestack-" +lib-version+ ".js")
             :checksum "FCA7F73803085DA47B4C5EBE9C007E5D")
   (sift :move {#"^filestack-\d+\.\d+\.\d+\.min\.js$" "cljsjs/filestack/production/filestack.min.inc.js"
                #"^filestack-\d+\.\d+\.\d+\.js$" "cljsjs/filestack/development/filestack.inc.js"})
   (target)
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.filestack")
   (pom)
   (jar)))
