{:foreign-libs [{:file "cljsjs/inferno/development/inferno.inc.js" :provides ["cljsjs.inferno"] :file-min "cljsjs/inferno/production/inferno.min.inc.js"}
                {:file "cljsjs/inferno/development/inferno-create-element.inc.js" :provides ["cljsjs.inferno.create-element"] :requires ["cljsjs.inferno"] :file-min "cljsjs/inferno/production/inferno-create-element.min.inc.js"}
                {:file "cljsjs/inferno/development/inferno-component.inc.js" :provides ["cljsjs.inferno.component"] :requires ["cljsjs.inferno"] :file-min "cljsjs/inferno/production/inferno-component.min.inc.js"}
                {:file "cljsjs/inferno/development/inferno-create-class.inc.js" :provides ["cljsjs.inferno.create-class"] :requires ["cljsjs.inferno" "cljsjs.inferno.component"] :file-min "cljsjs/inferno/production/inferno-create-class.min.inc.js"}
                {:file "cljsjs/inferno/development/inferno-hyperscript.inc.js" :provides ["cljsjs.inferno.hyperscript"] :requires ["cljsjs.inferno"] :file-min "cljsjs/inferno/production/inferno-hyperscript.min.inc.js"}]
 :externs ["cljsjs/inferno/common/inferno.ext.js"]}
