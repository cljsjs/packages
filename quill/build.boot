(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.3.5")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/quill
       :version     +version+
       :description "QuillJS is a modern rich text editor built for compatibility and extensibility."
       :url         "http://quilljs.com/"
       :license     {"BSD 3-Clause" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
         (comp
           (download :url (format "https://github.com/quilljs/quill/releases/download/v%s/quill.tar.gz" +lib-version+)
                     :decompress true
                     :archive-format "tar"
                     :compression-format "gz")
           (sift :move {#".*quill\.js" "cljsjs/quill/quill.inc.js"
                        #".*quill\.min\.js" "cljsjs/quill/quill.min.inc.js"
                        #".*quill\.core\.css" "cljsjs/quill/quill.core.css"
                        #".*quill\.snow\.css" "cljsjs/quill/quill.snow.css"})
           (sift :include #{#"^cljsjs"})
           (deps-cljs :name "cljsjs.quill")
           (validate-checksums)
           (pom)
           (jar)))
