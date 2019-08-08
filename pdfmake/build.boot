(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.1.26")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  push {:ensure-clean false}
  pom  {:project     'cljsjs/pdfmake
        :version     +version+
        :description "Client/server side PDF printing in pure JavaScript"
        :url         "http://pdfmake.org"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  ;;(task-options! push {:ensure-branch nil})
  (comp
   (download :url (format "https://github.com/bpampuch/pdfmake/archive/%s.zip" +lib-version+)
             :checksum "0fe4abd2db0927d05235665406c8b5a0"
             :unzip true)
   (sift :move {#"^pdfmake-[^\/]*/build/pdfmake\.min\.js" "cljsjs/production/pdfmake.inc.js"
                #"^pdfmake-[^\/]*/build/pdfmake\.js" "cljsjs/development/pdfmake.inc.js"
                #"^pdfmake-[^\/]*/build/vfs_fonts\.js" "cljsjs/development/vfsfonts.inc.js"
                #"^pdfmake-[^\/]*/build/vfs_fonts\.js" "cljsjs/production/vfsfonts.inc.js"})

   (sift :include #{#"^cljsjs" #"^deps\.cljs"})
   (pom)
   (jar)))
