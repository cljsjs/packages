(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.5.5")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project 'cljsjs/pouchdb-authentication
      :version +version+
      :description ""
      :url "https://github.com/nolanlawson/pouchdb-authentication"
      :scm {:url "https://github.com/cljsjs/packages"}
      :license {"Apache" "https://github.com/nolanlawson/pouchdb-authentication/raw/master/LICENSE"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/nolanlawson/pouchdb-authentication/archive/v" +lib-version+ ".zip")
             :checksum "4f99ede5494fa9bdc93626ce8e76a812"
             :unzip true)
   (sift :move {#"^pouchdb-authentication-([\d\.]*)/dist/pouchdb.authentication.js" "cljsjs/pouchdb-authentication/development/pouchdb-authentication.inc.js"
                #"^pouchdb-authentication-([\d\.]*)/dist/pouchdb.authentication.min.js" "cljsjs/pouchdb-authentication/production/pouchdb-authentication.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.pouchdb-authentication"
              :requires ["cljsjs.pouchdb"])
   (pom)
   (jar)))
