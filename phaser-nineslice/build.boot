(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]
                  [cljsjs/phaser-ce "2.8.2-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 push {:ensure-clean false}
 pom  {:project     'cljsjs/phaser-nineslice
       :version     +version+
       :description "NineSlice plugin for Phaser!"
       :url         "https://github.com/orange-games/phaser-nineslice"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/orange-games/phaser-nineslice"}})

(deftask package []
  (comp
   (download :url (format "https://github.com/orange-games/phaser-nineslice/releases/download/v%s/phaser-nineslice.js" +lib-version+)
             :checksum "0c980e7514775bdcaa2efb113a2bff87")
   (download :url (format "https://github.com/orange-games/phaser-nineslice/releases/download/v%s/phaser-nineslice.js.map" +lib-version+)
             :checksum "15614a1d726883987c33a286d38f361c")
   (download :url (format "https://github.com/orange-games/phaser-nineslice/releases/download/v%s/phaser-nineslice.min.js" +lib-version+)
             :checksum "61ba5bc1ff5d8f9c4125bd657df88f82")
   (sift :move {#"^phaser-nineslice\.js$"
                "cljsjs/phaser-nineslice/development/phaser-nineslice.inc.js"
                #"^phaser-nineslice\.map$"
                "cljsjs/phaser-nineslice/development/phaser-nineslice.map"
                #"^phaser-nineslice\.min\.js$"
                "cljsjs/phaser-nineslice/production/phaser-nineslice.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.phaser-nineslice"
              :requires ["cljsjs.phaser-ce"])
   (pom)
   (jar)))
