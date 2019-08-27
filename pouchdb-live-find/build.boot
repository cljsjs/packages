(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.2.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project 'cljsjs/pouchdb-live-find
      :version +version+
      :description "Live PouchDB queries that update automatically as changes come in!"
      :url "https://github.com/colinskow/pouchdb-live-find"
      :scm {:url "https://github.com/cljsjs/packages"}
      :license {"MIT" "https://github.com/colinskow/pouchdb-live-find/raw/master/LICENSE"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/colinskow/pouchdb-live-find/archive/v" +lib-version+ ".zip")
             :checksum "5D44A14E9BF98F65DA47FBC9120A5DBF"
             :unzip true)
   (sift :move {#"^pouchdb-live-find-([\d\.]*)/dist/pouchdb.live-find.js" "cljsjs/pouchdb-live-find/development/pouchdb-live-find.inc.js"
                #"^pouchdb-live-find-([\d\.]*)/dist/pouchdb.live-find.min.js" "cljsjs/pouchdb-live-find/production/pouchdb-live-find.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.pouchdb-live-find")
   (pom)
   (jar)))

