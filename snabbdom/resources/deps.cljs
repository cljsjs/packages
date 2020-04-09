{:foreign-libs [{:provides ["cljsjs.snabbdom" "snabbdom"]
                 :file "cljsjs/snabbdom/development/snabbdom.inc.js"
                 :file-min "cljsjs/snabbdom/production/snabbdom.min.inc.js"
                 :global-exports {"snabbdom" "snabbdom"}}
                {:provides ["cljsjs.snabbdom.modules.attributes" "snabbdom.modules.attributes"]
                 :file "cljsjs/snabbdom/development/snabbdom-attributes.inc.js"
                 :file-min "cljsjs/snabbdom/development/snabbdom-attributes.min.inc.js"
                 :global-exports {"snabbdom.modules.attributes" "snabbdom_attributes"}}
                {:provides ["cljsjs.snabbdom.modules.class" "snabbdom.modules.class"]
                 :file "cljsjs/snabbdom/development/snabbdom-class.inc.js"
                 :file-min "cljsjs/snabbdom/development/snabbdom-class.min.inc.js"
                 :global-exports {"snabbdom.modules.class" "snabbdom_class"}}
                {:provides ["cljsjs.snabbdom.modules.eventlisteners" "snabbdom.modules.eventlisteners"]
                 :file "cljsjs/snabbdom/development/snabbdom-eventlisteners.inc.js"
                 :file-min "cljsjs/snabbdom/development/snabbdom-eventlisteners.min.inc.js"
                 :global-exports {"snabbdom.modules.eventlisteners" "snabbdom_eventlisteners"}}
                {:provides ["cljsjs.snabbdom.modules.props" "snabbdom.modules.props"]
                 :file "cljsjs/snabbdom/development/snabbdom-props.inc.js"
                 :file-min "cljsjs/snabbdom/development/snabbdom-props.min.inc.js"
                 :global-exports {"snabbdom.modules.props" "snabbdom_props"}}
                {:provides ["cljsjs.snabbdom.modules.style" "snabbdom.modules.style"]
                 :file "cljsjs/snabbdom/development/snabbdom-style.inc.js"
                 :file-min "cljsjs/snabbdom/development/snabbdom-style.min.inc.js"
                 :global-exports {"snabbdom.modules.style" "snabbdom_style"}}]
 :externs ["cljsjs/snabbdom/common/snabbdom.ext.js"]}
