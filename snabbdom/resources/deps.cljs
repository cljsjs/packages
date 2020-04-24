{:foreign-libs [{:provides ["cljsjs.snabbdom" "snabbdom"]
                 :file "cljsjs/snabbdom/development/snabbdom.inc.js"
                 :file-min "cljsjs/snabbdom/production/snabbdom.min.inc.js"
                 :global-exports {"snabbdom" "snabbdom"}}
                {:provides ["snabbdom/modules/attributes"]
                 :file "cljsjs/snabbdom/development/snabbdom-attributes.inc.js"
                 :file-min "cljsjs/snabbdom/production/snabbdom-attributes.min.inc.js"
                 :global-exports {"snabbdom/modules/attributes" "snabbdom_attributes"}}
                {:provides ["snabbdom/modules/class"]
                 :file "cljsjs/snabbdom/development/snabbdom-class.inc.js"
                 :file-min "cljsjs/snabbdom/production/snabbdom-class.min.inc.js"
                 :global-exports {"snabbdom/modules/class" "snabbdom_class"}}
                {:provides ["snabbdom/modules/eventlisteners"]
                 :file "cljsjs/snabbdom/development/snabbdom-eventlisteners.inc.js"
                 :file-min "cljsjs/snabbdom/production/snabbdom-eventlisteners.min.inc.js"
                 :global-exports {"snabbdom/modules/eventlisteners" "snabbdom_eventlisteners"}}
                {:provides ["snabbdom/modules/props"]
                 :file "cljsjs/snabbdom/development/snabbdom-props.inc.js"
                 :file-min "cljsjs/snabbdom/production/snabbdom-props.min.inc.js"
                 :global-exports {"snabbdom/modules/props" "snabbdom_props"}}
                {:provides ["snabbdom/modules/style"]
                 :file "cljsjs/snabbdom/development/snabbdom-style.inc.js"
                 :file-min "cljsjs/snabbdom/production/snabbdom-style.min.inc.js"
                 :global-exports {"snabbdom/modules/style" "snabbdom_style"}}]
 :externs ["cljsjs/snabbdom/common/snabbdom.ext.js"]}
