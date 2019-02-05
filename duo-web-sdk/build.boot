(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.7")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/duo-web-sdk
       :version     +version+
       :description "This package allows a web developer to quickly add Duo's interactive, self-service, two-factor authentication to any web login form - without setting up secondary user accounts, directory synchronization, servers, or hardware."
       :url         "https://github.com/duosecurity/duo-web-sdk/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/duosecurity/duo_web_sdk/archive/" +lib-version+ ".zip")
             :checksum "c74047e026aff6bb8ea0b01f1cb8b436"
             :unzip true)
   (sift :move {#"^duo_web_sdk-([\d\.]*)/index.js" "cljsjs/duo-web-sdk/development/duo-web-sdk.inc.js"})
   (minify :in "cljsjs/duo-web-sdk/development/duo-web-sdk.inc.js"
           :out "cljsjs/duo-web-sdk/production/duo-web-sdk.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.duo-web-sdk")
   (pom)
   (jar)))
