{:foreign-libs [{:provides ["cljsjs.aws-cognito-sdk"]
                 :file "cljsjs/amazon-cognito-identity-js/development/aws-cognito-sdk.inc.js"
                 :file-min "cljsjs/amazon-cognito-identity-js/production/aws-cognito-sdk.inc.js"}
                {:provides ["cljsjs.amazon-cognito-identity-js"]
                 :requires ["cljsjs.aws-cognito-sdk"]
                 :file "cljsjs/amazon-cognito-identity-js/development/amazon-cognito-identity-js.inc.js"
                 :file-min "cljsjs/amazon-cognito-identity-js/production/amazon-cognito-identity-js.inc.js"}]
 :externs ["cljsjs/amazon-cognito-identity-js/common/amazon-cognito-identity-js.ext.js"]}
