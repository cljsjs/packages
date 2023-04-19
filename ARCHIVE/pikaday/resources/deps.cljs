{:foreign-libs [{:file "cljsjs/pikaday/development/pikaday.inc.js"
                 :provides ["cljsjs.pikaday"]
                 :file-min "cljsjs/pikaday/production/pikaday.min.inc.js"}
                {:file "cljsjs/pikaday/development/pikaday.inc.js"
                 :file-min "cljsjs/pikaday/production/pikaday.min.inc.js"
                 :requires ["cljsjs.moment"]
                 :provides ["cljsjs.pikaday.with-moment"]}]
 :externs ["cljsjs/pikaday/common/pikaday.ext.js"]}
