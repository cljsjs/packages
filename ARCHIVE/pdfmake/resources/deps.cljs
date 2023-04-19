{:foreign-libs
 [{:file "cljsjs/development/pdfmake.inc.js",
   :provides ["cljsjs.pdfmake"]}
  {:file "cljsjs/development/vfsfonts.inc.js",
   :provides ["cljsjs.pdfmakefonts"]
   :requires ["cljsjs.pdfmake"]}],
 :externs ["cljsjs/common/pdfmake.ext.js"]}
