(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.2.41")
(def +version+ (str +lib-version+ "-4"))

(task-options!
  pom  {:project     'cljsjs/aws-sdk-js
        :version     +version+
        :description "AWS Browser SDK"
        :url         "https://github.com/aws/aws-sdk-js"
        :license     {"MIT" "https://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (format "https://github.com/aws/aws-sdk-js/archive/v%s.zip" +lib-version+)
             :checksum "AD1C2413CC5DAE821DC5844936C54C4E"
             :unzip true)

   (sift :move {#"^aws-sdk-js-.*/dist/aws-sdk.js"  "cljsjs/aws-sdk-js/development/aws-sdk-js.inc.js"
                #"^aws-sdk-js-.*/dist/aws-sdk.min.js"  "cljsjs/aws-sdk-js/production/aws-sdk-js.min.inc.js"})

   (sift :include #{#"^cljsjs"})

   (deps-cljs :name "cljsjs.aws-sdk-js")
   (pom)
   (jar)))
