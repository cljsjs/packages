(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.2.8")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/amazon-cognito-identity-js
       :version     +version+
       :description "Amazon Cognito Identity SDK"
       :url         "https://github.com/aws-amplify/amplify-js/tree/master/packages/amazon-cognito-identity-js"
       :license     {"ASL" "https://aws.amazon.com/asl/"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url      (str "https://unpkg.com/amazon-cognito-identity-js@" +lib-version+ "/dist/amazon-cognito-identity.js")
             :target   "cljsjs/amazon-cognito-identity-js/development/amazon-cognito-identity.inc.js")
   (download :url      (str "https://unpkg.com/amazon-cognito-identity-js@" +lib-version+ "/dist/amazon-cognito-identity.min.js")
             :target   "cljsjs/amazon-cognito-identity-js/production/amazon-cognito-identity.min.inc.js")
   (deps-cljs :provides ["cljsjs.amazon-cognito-identity-js" "amazon-cognito-identity-js"])
   (pom)
   (jar)
   (validate)))
