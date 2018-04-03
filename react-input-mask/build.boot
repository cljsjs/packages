(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.0"  :scope "test"]
                 [cljsjs/react "16.3.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.2.2")
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
   (download :url (format "https://github.com/sanniassin/react-input-mask/archive/%s.zip" +lib-version+)
             :unzip true)
   (sift :move {#"^react-input-mask.*/dist/react-input-mask\.js$" "cljsjs/react-input-mask/development/react-input-mask.inc.js"
                #"^react-input-mask.*/dist/react-input-mask\.min\.js$" "cljsjs/react-input-mask/production/react-input-mask.min.inc.js" })
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.react-input-mask"
              :requires ["cljsjs.react"])
   (pom)
   (jar)
   (validate-checksums)))
