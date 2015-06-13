(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.4.0-0")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/oauthio
       :version     +version+
       :description "This is the JavaScript SDK for OAuth.io"
       :url         "https://oauth.io"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
    (download :url "https://github.com/oauth-io/oauth-js/archive/0.4.0.zip"
              :checksum "aa8812d0a90d337fdfd8079d7d58b874"
              :unzip true)
    (sift :move {#"^oauth-js-([\d\.]*)/dist/oauth\.js"      "cljsjs/oauthio/development/oauthio.inc.js"
                 #"^oauth-js-([\d\.]*)/dist/oauth\.min\.js" "cljsjs/oauthio/production/oauthio.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.oauthio")))
