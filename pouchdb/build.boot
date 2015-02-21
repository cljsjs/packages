(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.3" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "3.2.0-0")
(bootlaces! +version+)

(task-options!
 pom {:project 'cljsjs/pouchdb
      :version +version+
      :description "PouchDB packaged up with Google Closure externs"
      :url "http://pouchdb.com/"
      :scm {:url "https://github.com/cljsjs/packages"}
      :license {"Apache" "https://github.com/pouchdb/pouchdb/raw/master/LICENSE"}})

(deftask package []
  (comp
   (download :url "https://github.com/pouchdb/pouchdb/releases/download/3.3.0/pouchdb-3.3.0.js"
             :checksum "8A5C0C70FDDA68A41B2906D962A93784")
   (download :url "https://github.com/pouchdb/pouchdb/releases/download/3.3.0/pouchdb-3.3.0.min.js"
             :checksum "E04B63EEE45A0C93C6E5C116D21B268D")
   (sift :move {#"pouchdb-([\d+\.]*).js" "cljsjs/development/pouchdb.inc.js"
                #"pouchdb-([\d+\.]*).min.js" "cljsjs/production/pouchdb.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.pouchdb")))

