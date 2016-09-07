(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.10.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project 'cljsjs/pouchdb-find
      :version +version+
      :description "Easy-to-use query language for PouchDB"
      :url "https://github.com/nolanlawson/pouchdb-find"
      :scm {:url "https://github.com/cljsjs/packages"}
      :license {"Apache" "https://github.com/nolanlawson/pouchdb-find/raw/master/LICENSE"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/nolanlawson/pouchdb-find/archive/v" +lib-version+ ".zip")
             :checksum "5FB0970FD7EF1A7F5CED029F81C9ED79"
             :unzip true)
   (sift :move {#"^pouchdb-find-([\d\.]*)/dist/pouchdb.find.js" "cljsjs/pouchdb-find/development/pouchdb-find.inc.js"
                #"^pouchdb-find-([\d\.]*)/dist/pouchdb.find.min.js" "cljsjs/pouchdb-find/production/pouchdb-find.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.pouchdb-find")
   (pom)
   (jar)))

