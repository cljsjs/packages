{:foreign-libs [{:file "cljsjs/development/firebase.inc.js"
                 :provides ["cljsjs.firebase"]}
                {:file "cljsjs/development/firebase-node.inc.js"
                 :provides ["cljsjs.firebase-node"]}]
 :externs ["cljsjs/common/firebase-database-externs.js"
           "cljsjs/common/firebase-storage-externs.js"
           "cljsjs/common/firebase-auth-externs.js"
           "cljsjs/common/firebase-server-auth-externs.js"
           "cljsjs/common/firebase-app-externs.js"]}
