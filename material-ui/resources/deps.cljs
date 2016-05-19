{:foreign-libs [{:file     "cljsjs/material-ui/development/material-ui.inc.js",
                 :provides ["cljsjs.react" "cljsjs.material-ui"],
                 :file-min "cljsjs/material-ui/production/material-ui.min.inc.js"}
                {:file     "cljsjs/material-ui/development/material-ui-svg-icons.inc.js",
                 :provides ["cljsjs.material-ui-svg-icons"],
                 :requires ["cljsjs.material-ui"],
                 :file-min "cljsjs/material-ui/production/material-ui-svg-icons.min.inc.js"}],
 :externs      ["cljsjs/material-ui/common/react.ext.js"
                "cljsjs/material-ui/common/material-ui.ext.js"
                "cljsjs/material-ui/common/material-ui-svg-icons.ext.js"]}