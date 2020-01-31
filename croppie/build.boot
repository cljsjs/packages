(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.6.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/croppie
       :version     +version+
       :description "A Javascript Image Cropper"
       :url         "http://foliotek.github.io/Croppie/"
       :scm         {:url "https://github.com/Foliotek/Croppie"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/croppie@2.6.3/croppie.js" +lib-version+)
             :target "cljsjs/croppie/development/croppie.inc.js")
   (download :url (format "https://unpkg.com/croppie@2.6.3/croppie.min.js" +lib-version+)
             :target "cljsjs/croppie/production/croppie.min.inc.js")
   (deps-cljs :name "cljsjs.croppie")
   (pom)
   (jar)
   (validate)))
