(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project 'cljsjs/pouchdb-authentication
      :version +version+
      :description ""
      :url "https://github.com/pouchdb-community/pouchdb-authentication"
      :scm {:url "https://github.com/cljsjs/packages"}
      :license {"Apache" "https://github.com/pouchdb-community/pouchdb-authentication/raw/master/LICENSE"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/pouchdb-community/pouchdb-authentication/releases/download/v" +lib-version+ "/pouchdb.authentication.js")
             :checksum "96702e342830ede9d0cc1e423c921ddd")
   (download :url (str "https://github.com/pouchdb-community/pouchdb-authentication/releases/download/v" +lib-version+ "/pouchdb.authentication.min.js")
             :checksum "f36d054ea6937e30dde3c441a415a465")
   (sift :move {#"^pouchdb.authentication.js" "cljsjs/pouchdb-authentication/development/pouchdb-authentication.inc.js"
                #"^pouchdb.authentication.min.js" "cljsjs/pouchdb-authentication/production/pouchdb-authentication.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.pouchdb-authentication"
              :requires ["cljsjs.pouchdb"])
   (pom)
   (jar)))
