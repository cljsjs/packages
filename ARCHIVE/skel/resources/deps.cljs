{:foreign-libs [{:file "cljsjs/skel/development/skel.inc.js"
                 :file-min "cljsjs/skel/production/skel.min.inc.js"
                 :provides ["cljsjs.skel"]}
                {:file "cljsjs/skel/development/skel-layout.inc.js"
                 :file-min "cljsjs/skel/production/skel-layout.min.inc.js"
                 :requires ["cljsjs.skel"]
                 :provides ["cljsjs.skel-layout"]}
                {:file "cljsjs/skel/development/skel-viewport.inc.js"
                 :file-min "cljsjs/skel/production/skel-viewport.min.inc.js"
                 :requires ["cljsjs.skel"]
                 :provides ["cljsjs.skel-viewport"]}]
 :externs ["cljsjs/skel/common/skel.ext.js"]}
