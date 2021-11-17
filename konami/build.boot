(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.6.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/konami
       :version     +version+
       :description "A quick and silly script for adding the Konami Code easter egg to your site."
       :url         "https://konamijs.mand.is/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/konami@%s/konami.js" +lib-version+))
   (sift :move {#"^konami\.js" "cljsjs/konami/development/konami.inc.js"})
   (sift :include #{#"^cljsjs"})
   (minify :in "cljsjs/konami/development/konami.inc.js"
           :out "cljsjs/konami/production/konami.min.inc.js")
   (deps-cljs :provides ["cljsjs.konami"])
   (pom)
   (jar)
   (validate-checksums)))
