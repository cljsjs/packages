(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.0"  :scope "test"]
                 [cljsjs/react "16.3.0-1"]
                 [cljsjs/react-dom "16.3.0-1"]
                 [cljsjs/popperjs "1.14.3-0"]
                 [cljsjs/prop-types "15.6.0-0"]])

(def +lib-version+ "0.10.1")
(def +version+ (str +lib-version+ "-0"))

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/react-popper
       :version     +version+
       :description "React wrapper around PopperJS"
       :url         "https://github.com/souporserious/react-popper"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/react-popper@%s/dist/react-popper.umd.js" +lib-version+)
             :target "cljsjs/react-popper/development/react-popper.inc.js")
   (download :url (format "https://unpkg.com/react-popper@%s/dist/react-popper.umd.min.js" +lib-version+)
             :target "cljsjs/react-popper/production/react-popper.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.react-popper"
              :requires ["cljsjs.react"
                         "cljsjs.react.dom"
                         "cljsjs.popperjs"
                         "cljsjs.prop-types"])
   (pom)
   (jar)
   (validate-checksums)))
