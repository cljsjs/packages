(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]
                  [cljsjs/prop-types "15.5.10-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.1.4")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-tiny-virtual-list
       :version     +version+
       :description "A tiny but mighty list virtualization library, with zero dependencies"
       :url         "https://github.com/clauderic/react-tiny-virtual-list"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (format "https://unpkg.com/react-tiny-virtual-list@%s/build/react-tiny-virtual-list.js" +lib-version+))
    (download :url (format "https://unpkg.com/react-tiny-virtual-list@%s/build/react-tiny-virtual-list.min.js" +lib-version+))
    (sift :move {#"react-tiny-virtual-list.js"
                 "cljsjs/react-tiny-virtual-list/development/react-tiny-virtual-list.inc.js"
                 #"react-tiny-virtual-list.min.js"
                 "cljsjs/react-tiny-virtual-list/production/react-tiny-virtual-list.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-tiny-virtual-list"
               :requires ["cljsjs.prop-types"])
    (pom)
    (jar)
    (validate-checksums)))
