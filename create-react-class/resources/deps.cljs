{:foreign-libs [{:file "cljsjs/create-react-class/development/create-react-class.inc.js"
                 :provides ["create-react-class"]
                 :requires ["react"]
                 :global-exports {create-react-class createReactClass}
                 :file-min "cljsjs/create-react-class/production/create-react-class.min.inc.js"}
                {:file "cljsjs/create-react-class/development/create-react-class.inc.js"
                 :provides ["cljsjs.create-react-class"]
                 :requires ["cljsjs.react"]
                 :file-min "cljsjs/create-react-class/production/create-react-class.min.inc.js"}]
 :externs ["cljsjs/create-react-class/common/create-react-class.ext.js"]}

