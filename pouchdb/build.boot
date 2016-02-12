(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.2.0")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom {:project 'cljsjs/pouchdb
      :version +version+
      :description "PouchDB is an open-source JavaScript database inspired by Apache CouchDB that is designed to run well within the browser"
      :url "http://pouchdb.com/"
      :scm {:url "https://github.com/cljsjs/packages"}
      :license {"Apache" "https://github.com/pouchdb/pouchdb/raw/master/LICENSE"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/pouchdb/pouchdb/releases/download/" +lib-version+ "/pouchdb-" +lib-version+ ".js")
             :checksum "62A94E813C4922247BA69E22ACE95D32")
   (download :url (str "https://github.com/pouchdb/pouchdb/releases/download/" +lib-version+ "/pouchdb-" +lib-version+ ".min.js")
             :checksum "9F9DEBD0C45AEC539744FE5925BEF713")
   (sift :move {#"pouchdb-([\d+\.]*).js" "cljsjs/pouchdb/development/pouchdb.inc.js"
                #"pouchdb-([\d+\.]*).min.js" "cljsjs/pouchdb/production/pouchdb.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.pouchdb")))

