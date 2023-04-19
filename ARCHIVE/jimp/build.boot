(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(def +lib-version+ "0.2.27")

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
  pom {:project     'cljsjs/jimp
        :version     +lib-version+
        :description "The \"JavaScript Image Manipulation Program\" :-)"
        :url         "https://github.com/oliver-moran/jimp"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
    (download :url (format "https://cdn.rawgit.com/oliver-moran/jimp/v%s/browser/lib/jimp.js" +lib-version+)
      :checksum "BA6D8064314F7B3EA25EF504DCF2D81F")
    (download :url (format "https://cdn.rawgit.com/oliver-moran/jimp/v%s/browser/lib/jimp.min.js" +lib-version+)
      :checksum "A6C7BDB20B89AD1A0371CE8E91521EF7")
    (sift :move {#"jimp.js" "cljsjs/development/jimp.inc.js"
                  #"jimp.min.js" "cljsjs/production/jimp.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.jimp")
    (pom)
    (jar)))
