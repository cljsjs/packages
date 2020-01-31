(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.6.0")
(def +version+ (str +lib-version+ "-0"))
(def +sha+ "cc4abaf36d6b20f6c3d82ec8288a23be18e69b41")


(task-options!
 pom  {:project     'cljsjs/rot
       :version     +version+
       :description "This is rot.js, the ROguelike Toolkit in JavaScript."
       :url         "http://ondras.github.io/rot.js/hp/"
       :license     {"BSD" "https://github.com/ondras/rot.js/blob/master/license.txt"}
       :scm         {:url "https://github.com/cljsjs/packages"}})



(deftask package []
  (comp
   (download :url (format "https://raw.githubusercontent.com/ondras/rot.js/%s/rot.js" +sha+ ))
   (download :url (format "https://raw.githubusercontent.com/ondras/rot.js/%s/rot.min.js" +sha+ ))
   (sift :move {#"rot.js" "cljsjs/rot/development/rot.inc.js"
                #"rot.min.js" "cljsjs/rot/development/rot.min.inc.js"

})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.rot")
   (pom)
   (jar)))
