{:foreign-libs [{:file "cljsjs/pdfjs/common/pdf.inc.js"
                 :provides ["cljsjs.pdfjs"]
                 :requires ["cljsjs.pdfjs.worker"]}
                {:file "cljsjs/pdfjs/common/pdf.worker.inc.js"
                 :provides ["cljsjs.pdfjs.worker"]}]
 :externs ["cljsjs/pdfjs/common/pdf.ext.js"]}
