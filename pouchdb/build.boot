(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +upstream+ "3.5.0")
(def +revision+ "1")
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
             :checksum "BA1E518E08D71EDA0FF21C5E8F924406")
   (download :url (str "https://github.com/pouchdb/pouchdb/releases/download/" +upstream+ "/pouchdb-" +upstream+ ".min.js")
             :checksum "04598A4B41C584F04720B4E8BDB27B9D")
   (sift :move {#"pouchdb-([\d+\.]*).js" "cljsjs/pouchdb/development/pouchdb.inc.js"
                #"pouchdb-([\d+\.]*).min.js" "cljsjs/pouchdb/production/pouchdb.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.pouchdb")))

