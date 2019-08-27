(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]
                 [cljsjs/react "16.3.2-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-input-mask
       :version     +version+
       :description "Yet another react component for input masking"
       :url         "https://github.com/sanniassin/react-input-mask"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/react-input-mask@%s/dist/react-input-mask.js" +lib-version+)
             :target "cljsjs/react-input-mask/development/react-input-mask.inc.js")
   (download :url (format "https://unpkg.com/react-input-mask@%s/dist/react-input-mask.min.js" +lib-version+)
             :target "cljsjs/react-input-mask/production/react-input-mask.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.react-input-mask"
              :requires ["cljsjs.react"])
   (pom)
   (jar)
   (validate)))
