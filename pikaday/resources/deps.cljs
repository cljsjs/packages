{:foreign-libs [{:file "cljsjs/common/pikaday.inc.js"
                 :provides ["org.pikaday"]}
                {:file "cljsjs/common/pikaday.inc.js"
                 :requires ["org.moment"]
                 :provides ["org.pikaday.with-moment"]}]
 :externs ["cljsjs/common/pikaday.ext.js"]}
