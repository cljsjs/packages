(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.19.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/amazon-cognito-identity-js
        :version     +version+
        :description "Amazon Cognito Identity SDK"
        :url         "https://github.com/aws/amazon-cognito-identity-js"
        :license     {"MIT" "https://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (format "https://github.com/aws/amazon-cognito-identity-js/archive/v%s.zip" +lib-version+)
             :checksum "8515F5E1CEB6AEF8B3674675DFE4BF42"
             :unzip true)

   (sift :move {#"^amazon-cognito-identity-js-.*/dist/aws-cognito-sdk.js"         "cljsjs/amazon-cognito-identity-js/development/aws-cognito-sdk.inc.js"
                #"^amazon-cognito-identity-js-.*/dist/amazon-cognito-identity.js" "cljsjs/amazon-cognito-identity-js/development/amazon-cognito-identity-js.inc.js"

                #"^amazon-cognito-identity-js-.*/dist/aws-cognito-sdk.min.js"         "cljsjs/amazon-cognito-identity-js/production/aws-cognito-sdk.min.inc.js"
                #"^amazon-cognito-identity-js-.*/dist/amazon-cognito-identity.min.js" "cljsjs/amazon-cognito-identity-js/production/amazon-cognito-identity-js.min.inc.js"})

   (sift :include #{#"^cljsjs"})

   (deps-cljs :name "cljsjs.amazon-cognito-identity-js")
   (pom)
   (jar)))
