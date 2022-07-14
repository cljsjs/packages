(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.5.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project 'cljsjs/jspdf
       :version +version+
       :description "jsPDF - A library to generate PDFs in client-side JavaScript."
       :url "https://parall.ax/products/jspdf"
       :license {"MIT" "http://opensource.org/licenses/MIT"}
       :scm {:url "https://github.com/cljsjs/packages"}})

(defn unpkg-ver [file]
  (str "https://unpkg.com/jspdf@" 
       +lib-version+ 
       "/dist/"
       file))

(deftask package []
  (comp
   (download :url (unpkg-ver "jspdf.umd.js"))
   (download :url (unpkg-ver "jspdf.umd.min.js"))
   (sift :move
         {#"jspdf.umd.js" "cljsjs/jspdf/development/jspdf.inc.js"
          #"jspdf.umd.min.js" "cljsjs/jspdf/production/jspdf.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.jspdf")
   (pom)
   (jar)
   (validate)))
