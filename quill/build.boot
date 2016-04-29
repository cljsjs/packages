(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.20.0")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  pom {:project     'cljsjs/quill
       :version     +version+
       :description "Quill is a free, open source WYSIWYG editor built for the modern web."
       :url         "http://quilljs.com/"
       :license     {"BSD 3-Clause" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
         (comp
           (download :url (format "https://github.com/quilljs/quill/archive/v%s.zip" +lib-version+)
                     :unzip true)
           (sift :move {#".*dist/quill\.js"        "cljsjs/quill/development/quill.inc.js"
                        #".*dist/quill\.min\.js"   "cljsjs/quill/production/quill.min.inc.js"
                        #".*dist/quill\.base\.css" "cljsjs/quill/common/quill.base.css"
                        #".*dist/quill\.snow\.css" "cljsjs/quill/common/quill.snow.css"})
           (sift :include #{#"^cljsjs"})
           (deps-cljs :name "cljsjs.quill")
           (pom)
           (jar)))
