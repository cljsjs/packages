(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.0")
(def +version+ (str +lib-version+ "-3"))

(task-options!
  pom {:project     'cljsjs/quill
       :version     +version+
       :description "Quill is a free, open source WYSIWYG editor built for the modern web."
       :url         "http://quilljs.com/"
       :license     {"BSD 3-Clause" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
         (comp
           (download :url
                     (format "https://github.com/quilljs/quill/releases/download/v%s/quill.tar.gz" +lib-version+)
                     :decompress true
                     :archive-format "tar"
                     :compression-format "gz")
           (sift :move {#".*quill\.js"        "cljsjs/quill/quill.inc.js"
                        #".*quill\.min\.js"   "cljsjs/quill/quill.min.inc.js"
                        #".*quill\.core\.js"   "cljsjs/quill/quill.core.inc.js"
                        #".*quill\.core\.css" "cljsjs/quill/quill.core.css"
                        #".*dist/quill\.snow\.css" "cljsjs/quill/quill.snow.css"})
           (sift :include #{#"^cljsjs"})
           (deps-cljs :name "cljsjs.quill")
           (pom)
           (jar)))
