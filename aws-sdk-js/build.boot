(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.94.0")
(def +version+ (str +lib-version+ "-0"))

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
             :checksum "36614E16579D05E9031FA691A20E5FA3"
             :unzip true)

   (sift :move {#"^aws-sdk-js-.*/dist/aws-sdk.js"  "cljsjs/aws-sdk-js/development/aws-sdk-js.inc.js"
                #"^aws-sdk-js-.*/dist/aws-sdk.min.js"  "cljsjs/aws-sdk-js/production/aws-sdk-js.min.inc.js"})

   (sift :include #{#"^cljsjs"})

   (deps-cljs :name "cljsjs.aws-sdk-js")
   (pom)
   (jar)))
