{:foreign-libs 
 [{:file "cljsjs/aws-cognito-identity-js/development/aws-cognito-sdk.inc.js", 
   :provides ["cljsjs.aws-cognito-sdk"]}
  {:file "cljsjs/aws-cognito-identity-js/development/amazon-cognito-identity-js.inc.js", 
   :provides ["cljsjs.aws-cognito-identity-js"]
   :requires ["cljsjs.aws-cognito-sdk"
              "cljsjs.sjcl"
              "cljsjs.jsbn"]}],
 :externs ["cljsjs/aws-cognito-identity-js/common/aws-cognito-identity-js.ext.js"]}
