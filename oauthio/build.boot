(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.6.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/oauthio
       :version     +version+
       :description "This is the JavaScript SDK for OAuth.io"
       :url         "https://oauth.io"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/oauth-io/oauth-js/archive/%s.zip" +lib-version+)
              :checksum "89697A499DE3E3B3C9201CE7E281DCC0"
              :unzip true)
    (sift :move {#"^oauth-js-([\d\.]*)/dist/oauth\.js"      "cljsjs/oauthio/development/oauthio.inc.js"
                 #"^oauth-js-([\d\.]*)/dist/oauth\.min\.js" "cljsjs/oauthio/production/oauthio.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.oauthio")
    (pom)
    (jar)))
