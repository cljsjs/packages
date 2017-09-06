{:foreign-libs [{:file "cljsjs/leaflet-fullscreen/development/leaflet-fullscreen.inc.js"
                 :provides ["leaflet-fullscreen"]
                 :requires ["leaflet"]
                 :file-min "cljsjs/leaflet-fullscreen/production/leaflet-fullscreen.min.inc.js"}
                {:file "cljsjs/leaflet-fullscreen/development/leaflet-fullscreen.inc.js"
                 :provides ["cljsjs.leaflet-fullscreen"]
                 :requires ["cljsjs.leaflet"]
                 :file-min "cljsjs/leaflet-fullscreen/production/leaflet-fullscreen.min.inc.js"}]
 :externs ["cljsjs/leaflet-fullscreen/common/leaflet-fullscreen.ext.js"]}
