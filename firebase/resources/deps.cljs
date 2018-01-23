{:foreign-libs [{:file "cljsjs/development/firebase.inc.js"
                 :provides ["firebase" "cljsjs.firebase"] }
                {:file "cljsjs/development/firebase-firestore.inc.js"
                 :provides ["firebase.firestore"] } ]
 :externs ["cljsjs/common/firebase-database-externs.js"
           "cljsjs/common/firebase-storage-externs.js"
           "cljsjs/common/firebase-auth-externs.js"
           "cljsjs/common/firebase-server-auth-externs.js"
           "cljsjs/common/firebase-client-auth-externs.js"
           "cljsjs/common/firebase-messaging-externs.js"
           "cljsjs/common/firebase-error-externs.js"
           "cljsjs/common/firebase-app-externs.js"]}
