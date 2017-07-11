{:foreign-libs [{:file "cljsjs/react-dom/development/react-dom.inc.js"
                 :provides ["react-dom"]
                 :requires ["react"]
                 :js-global "ReactDOM"
                 :file-min "cljsjs/react-dom/production/react-dom.min.inc.js"}
                {:file "cljsjs/react-dom/development/react-dom.inc.js"
                 :provides ["cljsjs.react.dom"]
                 :requires ["cljsjs.react"]
                 :file-min "cljsjs/react-dom/production/react-dom.min.inc.js"}]
 :externs ["cljsjs/react-dom/common/react-dom.ext.js"]}

