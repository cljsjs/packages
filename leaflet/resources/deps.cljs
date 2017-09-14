{:foreign-libs [{:file "cljsjs/leaflet/development/leaflet.inc.js"
                 :provides ["cljsjs.leaflet" "leaflet"]
                 :global-exports {leaflet L}
                 :file-min "cljsjs/leaflet/production/leaflet.min.inc.js"}]
 :externs ["cljsjs/leaflet/common/leaflet.ext.js"]}
