
(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.14.1")

(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/reactable
       :version     +version+
       :description "Fast, flexible, and simple data tables in React."
       :url         "https://github.com/glittershark/reactable"
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (task-options! push {:ensure-branch nil})
  (comp
    (download
      :url (str "https://github.com/glittershark/reactable/archive/" +lib-version+ ".zip")
      :unzip true
      :checksum "649cd4d50cad6cb278db4416095c5423")
    (sift :move {(re-pattern (str "^reactable-" +lib-version+ "/build/reactable.js$")) "cljsjs/development/reactable.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.reactable"
               :requires ["cljsjs.react.dom"])
    (pom)
    (jar)))
