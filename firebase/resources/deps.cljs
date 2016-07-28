{:foreign-libs [{:file "cljsjs/development/firebase.inc.js"
                 :provides ["cljsjs.firebase"]}
                {:file "cljsjs/development/firebase-node.inc.js"
                 :provides ["cljsjs.firebase-node"]}]
 :externs ["cljsjs/common/firebase-database-externs.ext.js"
           "cljsjs/common/firebase-storage-externs.ext.js"
           "cljsjs/common/firebase-auth-externs.ext.js"
           "cljsjs/common/firebase-server-auth-externs.ext.js"
           "cljsjs/common/firebase-app-externs.ext.js"]}
