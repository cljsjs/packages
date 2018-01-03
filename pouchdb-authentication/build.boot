(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.9.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.0")
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
             :checksum "bf782a8e287ce25f973e7d75d6737d87")
   (download :url (str "https://github.com/pouchdb-community/pouchdb-authentication/releases/download/v" +lib-version+ "/pouchdb.authentication.min.js")
             :checksum "d1489bfcdd6525f768c7482ed9cf720d")
   (sift :move {#"^pouchdb.authentication.js" "cljsjs/pouchdb-authentication/development/pouchdb-authentication.inc.js"
                #"^pouchdb.authentication.min.js" "cljsjs/pouchdb-authentication/production/pouchdb-authentication.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.pouchdb-authentication"
              :requires ["cljsjs.pouchdb"])
   (pom)
   (jar)))
