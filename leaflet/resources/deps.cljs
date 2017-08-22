{:foreign-libs [{:file "cljsjs/leaflet/development/leaflet.inc.js"
                 :provides ["leaflet"]
                 :global-exports {leaflet L}
                 :file-min "cljsjs/leaflet/production/leaflet.min.inc.js"}
                {:file "cljsjs/leaflet/development/leaflet.inc.js"
                 :provides ["cljsjs.leaflet"]
                 :file-min "cljsjs/leaflet/production/leaflet.min.inc.js"}]
 :externs ["cljsjs/leaflet/common/leaflet.ext.js"]}
