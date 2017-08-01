{:foreign-libs [{:file "cljsjs/react-leaflet/development/react-leaflet.inc.js"
                 :provides ["react-leaflet"]
                 :requires ["leaflet" "react" "react-dom"]
                 :global-exports {react-leaflet ReactLeaflet}
                 :file-min "cljsjs/react-leaflet/production/react-leaflet.min.inc.js"}
                {:file "cljsjs/react-leaflet/development/react-leaflet.inc.js"
                 :provides ["cljsjs.leaflet"]
                 :requires ["cljsjs.leaflet" "cljsjs.react" "cljsjs.react.dom"]
                 :file-min "cljsjs/react-leaflet/production/react-leaflet.min.inc.js"}]
 :externs ["cljsjs/react-leaflet/common/react-leaflet.ext.js"]}
