(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "9.6.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/office-ui-fabric-core
       :version     +version+
       :description "The front-end CSS framework for building experiences for Office and Office 365"
       :url         "https://www.npmjs.com/package/office-ui-fabric-core"
       :scm         {:url "https://www.npmjs.com/package/office-ui-fabric-core"}
       :license     {"LICENSE" "https://github.com/OfficeDev/office-ui-fabric-core/blob/master/LICENSE"}})

(deftask package []
  (comp
    (download :url (format "https://raw.githubusercontent.com/OfficeDev/office-ui-fabric-core/%s/dist/css/fabric.css" +lib-version+))
    (sift :move {#"fabric\.css" "cljsjs/office-ui-fabric-core/development/fabric.css"})

    (download :url (format "https://raw.githubusercontent.com/OfficeDev/office-ui-fabric-core/%s/dist/css/fabric.min.css" +lib-version+))
    (sift :move {#"fabric\.min\.css" "cljsjs/office-ui-fabric-core/production/fabric.min.css"})

    (sift :include #{#"^cljsjs"})
    (pom)
    (jar)
    (validate-checksums)))
