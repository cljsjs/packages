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

(deftask uranium
  "Ensure uranium.js and uranium.js.mem are in target directory.  This is not
  needed to build the package, rather its for any projects using the package."
  []
  ;;uranium.js and uranium.js.mem need to both be in the same subdir as b4w's target html.
  (sift :add-jar {'cljsjs/blend4web #"^*/uranium.js*"}
        :move {#"^*cljsjs/blend4web/common/uranium.js"
               "uranium.js"}
        :to-resource #{#"uranium.js*"}))

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
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/tools/closure-compiler/extern_jquery-1.9.js" +lib-version+)
             :checksum "33aa6a7c3c07031da56881f6eb8e433c")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/tools/closure-compiler/extern_pointerlock.js" +lib-version+)
             :checksum "960a195b4ff3739ddc9047b42ce98a93")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/tools/closure-compiler/w3c_audio.js" +lib-version+)
             :checksum "4a109980ba9fa64f564365ac4a641b0d")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/tools/closure-compiler/w3c_dom1.js" +lib-version+)
             :checksum "745cfc581e8e901578f25d31a7442fdc")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/tools/closure-compiler/w3c_pointer_events.js" +lib-version+)
             :checksum "56267aaf833d54dc5f514ba9d41d80f8")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/anchors.js" +lib-version+)
             :checksum "93144B40886DCE8F1E4F01217CD48F48")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/animation.js" +lib-version+)
             :checksum "68bd0ffae33c634b445a4ad81ff2b314")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/armature.js" +lib-version+)
             :checksum "fd56a2dd9fce317b5373667d31ae5ddd")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/assets.js" +lib-version+)
             :checksum "fe3ba43c18e4bc5db5bd1a0a2fcea5a7")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/b4w.js" +lib-version+)
             :checksum "729b695260472aecd87472150a698045")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/camera.js" +lib-version+)
             :checksum "697b969db3d1491dba5c9cfda9381224")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/config.js" +lib-version+)
             :checksum "7ac699fd4298b364c79cb324cb409a7a")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/constraints.js" +lib-version+)
             :checksum "6fa7bd83cf18939b8bb38ef101cce69e")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/container.js" +lib-version+)
             :checksum "3480b9e46531e86c03b31add92af9499")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/controls.js" +lib-version+)
             :checksum "992b1003e2a1ad7db896e47f359ac5c9")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/data.js" +lib-version+)
             :checksum "9cff32c1a2f8823268ae7822efc53127")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/debug.js" +lib-version+)
             :checksum "210e8417d1f9f6649801a1f028f8f858")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/geometry.js" +lib-version+)
             :checksum "c3e5104b031c33566ddc52ee4718e84d")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/hud.js" +lib-version+)
             :checksum "616dc197f5aeb60488163e93ab5d9c01")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/input.js" +lib-version+)
             :checksum "01056cfec0b16fe4cf3dca219cdb112e")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/lights.js" +lib-version+)
             :checksum "f7ad2cd3a7f06614db99b17a15fd92c9")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/logic_nodes.js" +lib-version+)
             :checksum "4c0dd53fac2a043eed799e503b5364cc")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/main.js" +lib-version+)
             :checksum "6e4b80e67da6c661decb1148fc5d12c0")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/material.js" +lib-version+)
             :checksum "91034504d661782679e48a01379abbde")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/nla.js" +lib-version+)
             :checksum "02e2adcb3ab3e4efc26f9ec0ecddd7d5")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/objects.js" +lib-version+)
             :checksum "09c2ce7fd75ddb670f031de2476b192e")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/particles.js" +lib-version+)
             :checksum "af58e847ffdf3ae5e5871f2b66c7efa7")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/physics.js" +lib-version+)
             :checksum "884af1e4b71b43a5ecec5b53e8a9fc6d")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/rgb.js" +lib-version+)
             :checksum "cf89e1d29e4e746c5fde11e1d0e5f547")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/scenes.js" +lib-version+)
             :checksum "0a8ef3f432a801f112f9d90e34321f3e")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/sfx.js" +lib-version+)
             :checksum "6aef021ecd1453493085f4d478e165e5")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/textures.js" +lib-version+)
             :checksum "93b0022d9946dc4d5ba87e83c045ac41")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/time.js" +lib-version+)
             :checksum "38687cadd01cebf654d0859ae0a7c207")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/transform.js" +lib-version+)
             :checksum "7937ecc241322fa7e546315992149c7a")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/tsr.js" +lib-version+)
             :checksum "05307122008c3c6b19bf5137bdae89d2")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/util.js" +lib-version+)
             :checksum "732491e7a8c8db3cbd2fa8ca5f0f0090")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/src/ext/version.js" +lib-version+)
             :checksum "ebb10a947f1b609fc168838a73f1357f")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/deploy/apps/common/uranium.js" +lib-version+)
             :checksum "9B298C15DAE3D526F9652D896A088CC1")
   (download :url (format "https://raw.githubusercontent.com/TriumphLLC/Blend4Web/%s/deploy/apps/common/uranium.js.mem" +lib-version+)
             :checksum "3FF638D920819952240A1FDC28E6FD16")
   (sift :move {;;These are all the externs
                #"^b4w.js"
                "cljsjs/blend4web/common/b4w.ext.js"
                #"^extern_fullscreen.js"
                "cljsjs/blend4web/common/extern_fullscreen.ext.js"
                #"^extern_gl-matrix.js"
                "cljsjs/blend4web/common/extern_gl-matrix.ext.js"
                #"^extern_jquery-1.9.js"
                "cljsjs/blend4web/common/extern_jquery-1.9.ext.js"
                #"^extern_pointerlock.js"
                "cljsjs/blend4web/common/extern_pointerlock.ext.js"
                #"^w3c_audio.js"
                "cljsjs/blend4web/common/w3c_audio.ext.js"
                #"^w3c_dom1.js"
                "cljsjs/blend4web/common/w3c_dom1.ext.js"
                #"^w3c_pointer_events.js"
                "cljsjs/blend4web/common/w3c_pointer_events.ext.js"
                #"^extern_modules.js"
                "cljsjs/blend4web/common/extern_modules.ext.js"
                #"^anchors.js"
                "cljsjs/blend4web/common/anchors.ext.js"
                #"^animation.js"
                "cljsjs/blend4web/common/animation.ext.js"
                #"^armature.js"
                "cljsjs/blend4web/common/armature.ext.js"
                #"^assets.js"
                "cljsjs/blend4web/common/assets.ext.js"
                #"^camera.js"
                "cljsjs/blend4web/common/camera.ext.js"
                #"^config.js"
                "cljsjs/blend4web/common/config.ext.js"
                #"^constraints.js"
                "cljsjs/blend4web/common/constraints.ext.js"
                #"^container.js"
                "cljsjs/blend4web/common/container.ext.js"
                #"^controls.js"
                "cljsjs/blend4web/common/controls.ext.js"
                #"^data.js"
                "cljsjs/blend4web/common/data.ext.js"
                #"^debug.js"
                "cljsjs/blend4web/common/debug.ext.js"
                #"^geometry.js"
                "cljsjs/blend4web/common/geometry.ext.js"
                #"^hud.js"
                "cljsjs/blend4web/common/hud.ext.js"
                #"^input.js"
                "cljsjs/blend4web/common/input.ext.js"
                #"^lights.js"
                "cljsjs/blend4web/common/lights.ext.js"
                #"^logic_nodes.js"
                "cljsjs/blend4web/common/logic_nodes.ext.js"
                #"^main.js"
                "cljsjs/blend4web/common/main.ext.js"
                #"^material.js"
                "cljsjs/blend4web/common/material.ext.js"
                #"^math.js"
                "cljsjs/blend4web/common/math.ext.js"
                #"^nla.js"
                "cljsjs/blend4web/common/nla.ext.js"
                #"^objects.js"
                "cljsjs/blend4web/common/objects.ext.js"
                #"^particles.js"
                "cljsjs/blend4web/common/particles.ext.js"
                #"^physics.js"
                "cljsjs/blend4web/common/physics.ext.js"
                #"^rgb.js"
                "cljsjs/blend4web/common/rgb.ext.js"
                #"^scenes.js"
                "cljsjs/blend4web/common/scenes.ext.js"
                #"^sfx.js"
                "cljsjs/blend4web/common/sfx.ext.js"
                #"^textures.js"
                "cljsjs/blend4web/common/textures.ext.js"
                #"^time.js"
                "cljsjs/blend4web/common/time.ext.js"
                #"^transform.js"
                "cljsjs/blend4web/common/transform.ext.js"
                #"^tsr.js"
                "cljsjs/blend4web/common/tsr.ext.js"
                #"^util.js"
                "cljsjs/blend4web/common/util.ext.js"
                #"^version.js"
                "cljsjs/blend4web/common/version.ext.js"

                ;;Now for the compiled js
                #"^b4w.min.js"
                "cljsjs/blend4web/production/b4w.inc.js"

                ;You need uranium these last two in the same file as your html
                ;entry point.
                #"^uranium.js"
                "cljsjs/blend4web/common/uranium.js"
                #"^uranium.js.mem"
                "cljsjs/blend4web/common/uranium.js.mem"})

   (sift      :include   #{#"^cljsjs"})
   (deps-cljs :name     "blend4web")
   (show)
   (pom)
   (jar)))
