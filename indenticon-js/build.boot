(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.3.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'io.github.cljsjs/indenticon-js
       :version     +version+
       :description "GitHub-style identicons as PNGs or SVGs in JS"
       :url         "https://github.com/stewartlord/identicon.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD 2-Clause" "https://opensource.org/licenses/BSD-2-Clause"}})

(deftask package []
  (comp
   (download
    :url (format "https://cdnjs.cloudflare.com/ajax/libs/identicon.js/%s/identicon.min.js" +lib-version+)
    :target "cljsjs/indenticon-js/production/identicon-js.min.inc.js")
   (download
    :url (format "https://cdnjs.cloudflare.com/ajax/libs/identicon.js/%s/identicon.min.js" +lib-version+)
    :target "cljsjs/indenticon-js/development/identicon-js.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.identicon-js")
   (pom)
   (jar)
   (validate-checksums)))
