(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[boot.task-helpers]
         '[cljsjs.boot-cljsjs.packaging :refer :all])


(def +lib-version+ "1.11.0")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  push {:ensure-clean false}
  pom  {:project     'cljsjs/aws-cognito-identity-js
        :version     +version+
        :description "Amazon Cognito Identity SDK for JavaScript"
        :url         "https://github.com/aws/amazon-cognito-identity-js/blob/master/dist/amazon-cognito-identity.min.js"
        :license     {"ASL" "https://aws.amazon.com/asl/"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask package []
  (comp
   (download :url (format "https://github.com/aws/amazon-cognito-identity-js/archive/v%s.zip" +lib-version+)
             :checksum "E3D5E3330ED8B7140913A69351E457FC"
             :unzip true)

   (sift :move {#"^amazon-cognito-identity-js-.*/dist/amazon-cognito-identity.min.js" 
                "cljsjs/aws-cognito-identity-js/development/amazon-cognito-identity-js.inc.js"

                #"^amazon-cognito-identity-js-.*/dist/amazon-cognito-identity.min.js" 
                "cljsjs/aws-cognito-identity-js/production/amazon-cognito-identity-js.min.inc.js"

                #"^amazon-cognito-identity-js-.*/dist/aws-cognito-sdk.js" 
                "cljsjs/aws-cognito-identity-js/development/aws-cognito-sdk.inc.js"

                #"^amazon-cognito-identity-js-.*/dist/aws-cognito-sdk.min.js" 
                "cljsjs/aws-cognito-identity-js/development/aws-cognito-sdk.min.inc.js"})

   (sift :include #{#"^cljsjs" #"^deps\.cljs"})

   (pom)
   (jar)))
