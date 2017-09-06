{:foreign-libs [{:file "cljsjs/uikit/development/uikit.inc.js"
                 :file-min "cljsjs/uikit/production/uikit.min.inc.js"
                 :requires ["cljsjs.jquery"]
                 :provides ["cljsjs.uikit"]}
                {:file "cljsjs/uikit/development/uikit-icons.inc.js"
                 :file-min "cljsjs/uikit/production/uikit-icons.min.inc.js"
                 :requires ["cljsjs.uikit"]
                 :provides ["cljsjs.uikit-icons"]}]
 :externs ["cljsjs/uikit/common/uikit.ext.js"]}
