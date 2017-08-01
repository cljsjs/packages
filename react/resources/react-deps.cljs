{:foreign-libs [{:file "cljsjs/react/development/react.inc.js"
                 :provides ["react"]
                 :global-exports {react React}
                 :file-min "cljsjs/react/production/react.min.inc.js"}
                {:file "cljsjs/react/development/react.inc.js"
                 :provides ["cljsjs.react"]
                 :file-min "cljsjs/react/production/react.min.inc.js"}]
 :externs ["cljsjs/react/common/react.ext.js"]}
