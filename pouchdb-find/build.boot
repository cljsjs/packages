(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.9.0" :scope "test"]
                  [cljsjs/pouchdb "6.3.4-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "6.3.4")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project 'cljsjs/pouchdb-find
      :version +version+
      :description "Easy-to-use query language for PouchDB"
      :url "https://github.com/pouchdb/pouchdb/"
      :scm {:url "https://github.com/cljsjs/packages"}
      :license {"Apache" "https://github.com/pouchdb/pouchdb/raw/master/LICENSE"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/pouchdb/pouchdb/releases/download/" +lib-version+ "/pouchdb.find.js")
             :checksum "73204FB154BA4AA589EA5B1089635C25")
   (download :url (str "https://github.com/pouchdb/pouchdb/releases/download/" +lib-version+ "/pouchdb.find.min.js")
             :checksum "4345BF962BB647D8D9456124333D5370")
   (sift :move {#"^pouchdb.find.js" "cljsjs/pouchdb-find/development/pouchdb-find.inc.js"
                #"^pouchdb.find.min.js" "cljsjs/pouchdb-find/production/pouchdb-find.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.pouchdb-find"
              :requires ["cljsjs.pouchdb"])
   (pom)
   (jar)))


