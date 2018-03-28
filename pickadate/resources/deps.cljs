{:foreign-libs [{:file     "cljsjs/pickadate/development/picker.inc.js"
                 :file-min "cljsjs/pickadate/production/picker.min.inc.js"
                 :provides ["cljsjs.pickadate"]}
                {:file     "cljsjs/pickadate/development/picker.date.inc.js"
                 :file-min "cljsjs/pickadate/production/picker.date.min.inc.js"
                 :requires ["cljsjs.pickadate"]
                 :provides ["cljsjs.pickadate.date"]}
                {:file     "cljsjs/pickadate/development/picker.time.inc.js"
                 :file-min "cljsjs/pickadate/production/picker.time.min.inc.js"
                 :requires ["cljsjs.pickadate"]
                 :provides ["cljsjs.pickadate.time"]}]
 :externs      ["cljsjs/pickadate/common/pickadate.ext.js"]}
