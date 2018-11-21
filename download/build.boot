(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot])

(def +lib-version+ "1.4.6")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/download
       :version     +version+
       :description "Client-side file downloading using JS and HTML5"
       :url         "http://danml.com/download.html"
       :scm         {:url "https://github.com/rndme/download"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/rndme/download/archive/v" +lib-version+ ".zip")
             :checksum "6F37C1A62C8E93FEB1F63381729D0A4A"
             :unzip true)
   (show :fileset true)
   (sift :move {#"download-.+/download.js" "cljsjs/download/development/download.inc.js"
                #"download-.+/download.min.js" "cljsjs/download/production/download.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (show :fileset true)
   (deps-cljs :name "cljsjs.download")
   (pom)
   (jar)))
