(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.3.2")
(def +version+ (str +lib-version+ "-2"))

(task-options!
  pom {:project 'cljsjs/jspdf
       :version +version+
       :description "jsPDF - A library to generate PDFs in client-side JavaScript."
       :url "https://parall.ax/products/jspdf"
       :license {"MIT" "http://opensource.org/licenses/MIT"}
       :scm {:url "https://github.com/cljsjs/packages"}})

(defn cdn-ver [file]
  (str "https://cdnjs.cloudflare.com/ajax/libs/jspdf/"
       +lib-version+ "/" file))

(deftask package []
  (comp
    (download :url (cdn-ver "jspdf.debug.js"))
    (download :url (cdn-ver "jspdf.min.js"))
    (sift :move
          {#"jspdf.debug.js" "cljsjs/jspdf/development/jspdf.inc.js"
           #"jspdf.min.js" "cljsjs/jspdf/production/jspdf.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.jspdf")
    (pom)
    (jar)))
