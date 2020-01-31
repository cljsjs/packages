(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.2.6")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom {:project     'cljsjs/emojione
      :version     +version+
      :description "EmojiOne™ is the open emoji standard."
      :scm         {:url "https://github.com/Ranks/emojione"}
      :url         "http://www.emojione.com/"})

(deftask package []
  (comp
   (download :url (str "https://github.com/Ranks/emojione/archive/v" +lib-version+ ".zip")
             :checksum "c7520355d26f2aea28b83ec8d6101fbb"
             :unzip true)
   (sift :move {#"^emojione-\d\.\d\.\d/lib/js/emojione\.min\.js$" "cljsjs/emojione/production/emojione.min.inc.js"
                #"^emojione-\d\.\d\.\d/lib/js/emojione\.js$" "cljsjs/emojione/development/emojione.inc.js"
                #"^emojione-\d\.\d\.\d/assets/(.+)$" "cljsjs/emojione/common/$1"})
   (sift :include #{#"^cljsjs/emojione/common/(fonts|png_512x512)"} :invert true)
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.emojione")
   (pom)
   (jar)))