(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.8")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/office-js
       :version     +version+
       :description "Office JavaScript APIs"
       :url         "https://www.npmjs.com/package/@microsoft/office-js"
       :scm         {:url "https://www.npmjs.com/package/@microsoft/office-js"}
       :license     {"LICENSE" "https://unpkg.com/@microsoft/office-js/LICENSE"}})

(deftask package []
  (comp
    (download :url (format "https://unpkg.com/@microsoft/office-js@%s/dist/office.debug.js" +lib-version+))
    (sift :move {#"office\.debug\.js" "cljsjs/office-js/development/office-js.inc.js"})

    (download :url (format "https://unpkg.com/@microsoft/office-js@%s/dist/office.js" +lib-version+))
    (sift :move {#"office\.js" "cljsjs/office-js/production/office-js.min.inc.js"})

    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.office-js")
    (pom)
    (jar)
    (validate-checksums)))
