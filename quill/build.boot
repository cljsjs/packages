(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces "0.1.10" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.20.0")
(bootlaces! +version+)

(task-options!
  pom {:project     'cljsjs/quill
       :version     +version+
       :description "Quill is a free, open source WYSIWYG editor built for the modern web."
       :url         "http://quilljs.com/"
       :license     {"BSD 3-Clause" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
         (comp
           (download :url "https://github.com/quilljs/quill/archive/v0.20.0.zip"
                     :unzip true)
           (sift :move {#".*dist/quill\.js"        "cljsjs/quill/development/quill.inc.js"
                        #".*dist/quill\.min\.js"   "cljsjs/quill/production/quill.min.inc.js"
                        #".*dist/quill\.base\.css" "cljsjs/quill/common/quill.base.css"
                        #".*dist/quill\.snow\.css" "cljsjs/quill/common/quill.snow.css"})
           (sift :include #{#"^cljsjs"})
           (deps-cljs :name "cljsjs.quill")))