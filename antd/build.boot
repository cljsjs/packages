(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]
                 [cljsjs/react "15.4.0-0"]
                 [cljsjs/react-dom "15.4.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.6.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 push {:ensure-clean false}
 pom  {:project     'cljsjs/antd
       :version     +version+
       :description "One design language http://ant.design"
       :url         "https://github.com/ant-design/ant-design"
       :license     {"MIT" "https://raw.githubusercontent.com/ant-design/ant-design/master/LICENSE"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp

   (download :url (str "https://unpkg.com/antd@" +lib-version+ "/dist/antd.js")
             :checksum "0F0AA6FE0E81F39886E6E11CC6542A90"
             :unzip false)

   (download :url (str "https://unpkg.com/antd@" +lib-version+ "/dist/antd.min.js")
             :checksum "9B2D7AAB88B1262FE32B85E645331297"
             :unzip false)

   (sift :move {#"^antd.js$"     "cljsjs/antd/development/antd.inc.js"
                #"^antd.min.js$" "cljsjs/antd/production/antd.min.inc.js"})

   (sift :include #{#"cljsjs"})

   (deps-cljs :name "cljsjs.antd"
              :requires ["cljsjs.react"
                         "cljsjs.react.dom"])

   (pom)

   (jar)))
