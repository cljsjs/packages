(def +lib-version+ "16.11")
(def +version+ (str +lib-version+ "-1"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.task.built-in :refer :all])

(task-options!
 pom  {:project     'cljsjs/blend4web
       :version     +version+
       :description "Blend4Web -- Javascript WebGL Framework by Triump LLC"
       :url         "http://www.blend4web.org/"
       :license     {"GPL3" "https://github.com/TriumphLLC/Blend4Web/blob/master/license/GPL-license.txt"}
       :scm {:url   "https://github.com/cljsjs/packages"}})

; (deftask uranium
;   "Ensure uranium.js and uranium.js.mem are in target directory.  This is not
;   needed to build the package, rather its for any projects using the package."
;   []
;   ;;uranium.js and uranium.js.mem need to both be in the same subdir as b4w's target html.
;   (sift :add-jar {'cljsjs/blend4web #"^*/uranium.js*"}
;         :move {#"^*cljsjs/blend4web/common/uranium.js"
;                "uranium.js"}
;         :to-resource #{#"uranium.js*"}))

(deftask package []
  (comp
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/deploy/apps/common/b4w.min.js" +lib-version+)
             :checksum "316e4cb2748cb72bc5a563d1f7fe354c")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/tools/closure-compiler/extern_fullscreen.js" +lib-version+)
             :checksum "fe0a688b40a2f0c672e779f0aaced2a8")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/tools/closure-compiler/extern_modules.js" +lib-version+)
             :checksum "9cd667bcb91b219429d604c938f7796c")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/tools/closure-compiler/extern_gl-matrix.js" +lib-version+)
             :checksum "6a59beeb17a53e793ffe982d5be20ab0")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/tools/closure-compiler/extern_pointerlock.js" +lib-version+)
             :checksum "960a195b4ff3739ddc9047b42ce98a93")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/b4w.js" +lib-version+)
             :checksum "729b695260472aecd87472150a698045")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/deploy/apps/common/uranium.js" +lib-version+)
             :checksum "9B298C15DAE3D526F9652D896A088CC1")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/deploy/apps/common/uranium.js.mem" +lib-version+)
             :checksum "3FF638D920819952240A1FDC28E6FD16")

   (sift :move {;;These are all the externs
                #"^b4w.js"               "cljsjs/blend4web/common/b4w.ext.js"
                #"^extern_fullscreen.js" "cljsjs/blend4web/common/extern_fullscreen.ext.js"
                #"^extern_gl-matrix.js"  "cljsjs/blend4web/common/extern_gl-matrix.ext.js"
                #"^extern_jquery-1.9.js" "cljsjs/blend4web/common/extern_pointerlock.ext.js"
                #"^extern_modules.js"    "cljsjs/blend4web/common/extern_modules.ext.js"

                ;;Now for the compiled js
                #"^b4w.min.js" "cljsjs/blend4web/production/b4w.inc.js"

                ;You need uranium these last two in the same file as your html
                ;entry point.
                #"^uranium.js"     "cljsjs/blend4web/common/uranium.js"
                #"^uranium.js.mem" "cljsjs/blend4web/common/uranium.js.mem"})

   (sift      :include   #{#"^cljsjs"})
   (deps-cljs :name     "blend4web")
   (show)
   (pom)
   (jar)))
