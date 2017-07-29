{:foreign-libs [{:file "cljsjs/react-dom-server/development/react-dom-server.inc.js"
                 :provides ["react-dom/server"]
                 :requires ["react"]
                 :global-exports {react-dom/server ReactDOMServer}
                 :file-min "cljsjs/react-dom-server/production/react-dom-server.min.inc.js"}
                {:file "cljsjs/react-dom-server/development/react-dom-server.inc.js"
                 :provides ["cljsjs.react.dom.server"]
                 :requires ["cljsjs.react"]
                 :file-min "cljsjs/react-dom-server/production/react-dom-server.min.inc.js"}]
 :externs ["cljsjs/react-dom-server/common/react-dom-server.ext.js"]}
