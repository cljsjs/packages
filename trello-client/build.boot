(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.2"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.0.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/trello-client
      :version     +version+
       :description "Trello client js"
       :url         "https://developers.trello.com/clientjs"
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
    (download  :url "https://trello.com/1/client.js")
    (sift      :move     {#"client.js" "cljsjs/trello-client/production/trello-client.inc.js"
                          #"client.js" "cljsjs/trello-client/development/trello-client.min.inc.js"})
    (sift      :include  #{#"^cljsjs"})
    (show      :fileset  true)
    (deps-cljs :name     "cljsjs.trello-client")
    (pom)
    (jar)))
