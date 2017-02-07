{:foreign-libs [{:file "cljsjs/linkify/development/linkify.inc.js",
                 :provides ["cljsjs.linkify"],
                 :file-min "cljsjs/linkify/production/linkify.min.inc.js"}
                {:file "cljsjs/linkify/development/linkify-string.inc.js",
                 :provides ["cljsjs.linkify-string"],
                 :requires ["cljsjs.linkify"],
                 :file-min "cljsjs/linkify/production/linkify-string.min.inc.js"}
                {:file "cljsjs/linkify/development/linkify-react.inc.js",
                 :provides ["cljsjs.linkify-react"],
                 :requires ["cljsjs.linkify", "cljsjs.react"],
                 :file-min "cljsjs/linkify/production/linkify-react.min.inc.js"}
                {:file "cljsjs/linkify/development/linkify-polyfill.inc.js",
                 :provides ["cljsjs.linkify-polyfill"],
                 :requires ["cljsjs.linkify"],
                 :file-min "cljsjs/linkify/production/linkify-polyfill.min.inc.js"}
                {:file "cljsjs/linkify/development/linkify-plugin-ticket.inc.js",
                 :provides ["cljsjs.linkify-plugin-ticket"],
                 :requires ["cljsjs.linkify"],
                 :file-min "cljsjs/linkify/production/linkify-plugin-ticket.min.inc.js"}
                {:file "cljsjs/linkify/development/linkify-plugin-mention.inc.js",
                 :provides ["cljsjs.linkify-plugin-mention"],
                 :requires ["cljsjs.linkify"],
                 :file-min "cljsjs/linkify/production/linkify-plugin-mention.min.inc.js"}
                {:file "cljsjs/linkify/development/linkify-plugin-hashtag.inc.js",
                 :provides ["cljsjs.linkify-plugin-hashtag"],
                 :requires ["cljsjs.linkify"],
                 :file-min "cljsjs/linkify/production/linkify-plugin-hashtag.min.inc.js"}
                {:file "cljsjs/linkify/development/linkify-jquery.inc.js",
                 :provides ["cljsjs.linkify-jquery"],
                 :requires ["cljsjs.linkify" "cljsjs.jquery"],
                 :file-min "cljsjs/linkify/production/linkify-jquery.min.inc.js"}
                {:file "cljsjs/linkify/development/linkify-html.inc.js",
                 :provides ["cljsjs.linkify-html"],
                 :requires ["cljsjs.linkify"],
                 :file-min "cljsjs/linkify/production/linkify-html.min.inc.js"}
                {:file "cljsjs/linkify/development/linkify-element.inc.js",
                 :provides ["cljsjs.linkify-element"],
                 :requires ["cljsjs.linkify"],
                 :file-min "cljsjs/linkify/production/linkify-element.min.inc.js"}],
 :externs ["cljsjs/linkify/common/linkify.ext.js"
           "cljsjs/linkify/common/linkify-string.ext.js"
           "cljsjs/linkify/common/linkify-react.ext.js"
           "cljsjs/linkify/common/linkify-jquery.ext.js"
           "cljsjs/linkify/common/linkify-html.ext.js"
           "cljsjs/linkify/common/linkify-element.ext.js"]}