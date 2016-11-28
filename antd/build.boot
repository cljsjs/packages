(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]
                 [cljsjs/react "15.4.0-0"]
                 [cljsjs/react-dom "15.4.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.5.0")
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
             :checksum "CD24357C010D1F13D6A9A37F060DD0DB"
             :unzip false)

   (download :url (str "https://unpkg.com/antd@" +lib-version+ "/dist/antd.min.js")
             :checksum "87D030B4EF87E5C2ABC16DD294FEB550"
             :unzip false)

   (sift :move {#"^antd.js$"     "cljsjs/antd/development/antd.inc.js"
                #"^antd.min.js$" "cljsjs/antd/production/antd.min.inc.js"})

   (sift :include #{#"cljsjs"})

   (deps-cljs :name "cljsjs.antd"
              :requires ["cljsjs.react"
                         "cljsjs.react.dom"])

   (pom)

   (jar)))
