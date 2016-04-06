{:foreign-libs
        [{:file "cljsjs/react-mdl/development/ReactMDL.inc.js"
          :file-min "cljsjs/react-mdl/production/ReactMDL.min.inc.js"
          :provides ["cljsjs.react-mdl"]
          :requires ["cljsjs.react" "cljsjs.react-mdl-extra"]}
        {:file "cljsjs/react-mdl/development/material.inc.js"
         :file-min "cjsjs/react-mdl/production/material.min.inc.js"
         :provides ["cljsjs.react-mdl-extra"]}]
 :externs ["cljsjs/react-mdl/common/react-mdl.ext.js" "cljsjs/react-mdl/react-mdl-extra.ext.js"]}
