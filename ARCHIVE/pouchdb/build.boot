(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "7.0.0")
(def +version+ (str +lib-version+ "-0"))

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
             :checksum "035388144d999082b596effe24f390b1")
   (download :url (str "https://github.com/pouchdb/pouchdb/releases/download/" +lib-version+ "/pouchdb-" +lib-version+ ".min.js")
             :checksum "12d23e3295590b71657939cdb7aba451")
   (sift :move {#"pouchdb-([\d+\.]*).js" "cljsjs/pouchdb/development/pouchdb.inc.js"
                #"pouchdb-([\d+\.]*).min.js" "cljsjs/pouchdb/production/pouchdb.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.pouchdb")
   (pom)
   (jar)))

