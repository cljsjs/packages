{:foreign-libs [{:file "cljsjs/development/firebase.inc.js"
                 :provides ["firebase" "cljsjs.firebase"]}
                {:file "cljsjs/development/firebase-app.inc.js"
                 :provides ["firebase.app"]}
                {:file "cljsjs/development/firebase-auth.inc.js"
                 :provides ["firebase.auth"]}
                {:file "cljsjs/development/firebase-database.inc.js"
                 :provides ["firebase.database"]}
                {:file "cljsjs/development/firebase-firestore.inc.js"
                 :provides ["firebase.firestore"]}
                {:file "cljsjs/development/firebase-functions.inc.js"
                  :provides ["firebase.functions"]}
                {:file "cljsjs/development/firebase-messaging.inc.js"
                 :provides ["firebase.messaging"]}
                {:file "cljsjs/development/firebase-storage.inc.js"
                 :provides ["firebase.storage"]}]

 :externs ["cljsjs/common/firebase-externs.js"
           "cljsjs/common/firebase-app-externs.js"
           "cljsjs/common/firebase-app-internal-externs.js"
           "cljsjs/common/firebase-auth-externs.js"
           "cljsjs/common/firebase-client-auth-externs.js"
           "cljsjs/common/firebase-database-externs.js"
           "cljsjs/common/firebase-database-internal-externs.js"
           "cljsjs/common/firebase-error-externs.js"
           "cljsjs/common/firebase-firestore-externs.js"
           "cljsjs/common/firebase-messaging-externs.js"
           "cljsjs/common/firebase-storage-externs.js"]}
