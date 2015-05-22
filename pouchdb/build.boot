(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +upstream+ "3.5.0")
(def +revision+ "0")
(def +version+ (str +upstream+ "-" +revision+))
(bootlaces! +version+)

(task-options!
 pom {:project 'cljsjs/pouchdb
      :version +version+
      :description "PouchDB is an open-source JavaScript database inspired by Apache CouchDB that is designed to run well within the browser"
      :url "http://pouchdb.com/"
      :scm {:url "https://github.com/cljsjs/packages"}
      :license {"Apache" "https://github.com/pouchdb/pouchdb/raw/master/LICENSE"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/pouchdb/pouchdb/releases/download/" +upstream+ "/pouchdb-" +upstream+ ".js")
             :checksum "893386BACBC08648E9F7DBA35CC7797F")
   (download :url (str "https://github.com/pouchdb/pouchdb/releases/download/" +upstream+ "/pouchdb-" +upstream+ ".min.js")
             :checksum "B102D1867A877F0791D27A79EFC1A65F")
   (sift :move {#"pouchdb-([\d+\.]*).js" "cljsjs/pouchdb/development/pouchdb.inc.js"
                #"pouchdb-([\d+\.]*).min.js" "cljsjs/pouchdb/production/pouchdb.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.pouchdb")))

