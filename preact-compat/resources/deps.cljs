{:foreign-libs [{:provides ["cljsjs.react" "cljsjs.react.dom"]
                 :requires ["cljsjs.preact-compat"]
                 :file "cljsjs/preact-compat/common/react.inc.js"}
                {:provides ["cljsjs.preact-compat"]
                 :requires ["cljsjs.preact" "cljsjs.proptypes"]
                 :file "cljsjs/preact-compat/development/preact-compat.inc.js"
                 :file-min "cljsjs/preact-compat/production/preact-compat.min.inc.js"}]
 :externs ["cljsjs/preact-compat/common/preact-compat.ext.js"]}
