(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]
                 [cljsjs/react "15.4.2-2"]
                 [cljsjs/react-dom "15.4.2-2"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.11.2")
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

   (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/antd/" +lib-version+ "/antd-with-locales.js")
             :checksum "9EAE67CC4C6E04F7AFCFF310EFC108EE"
             :unzip false)

   (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/antd/" +lib-version+ "/antd-with-locales.min.js")
             :checksum "C74A69A15AD5D1F445F95CBB97505F4D"
             :unzip false)

   (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/antd/" +lib-version+ "/antd.css")
             :checksum "B2B09E4D5144ADA3EAF2956EF7639B57"
             :unzip false)

   (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/antd/" +lib-version+ "/antd.min.css")
             :checksum "0BDED055B5186C84E0F21C8FEF40BA42"
             :unzip false)

   (sift :move {#"^antd-with-locales.js$"     "cljsjs/antd/development/antd.inc.js"
                #"^antd-with-locales.min.js$" "cljsjs/antd/production/antd.min.inc.js"
                #"^antd.css$"                 "cljsjs/antd/development/antd.inc.css"
                #"^antd.min.css$"             "cljsjs/antd/production/antd.min.inc.css"})

   (sift :include #{#"cljsjs"})

   (deps-cljs :name "cljsjs.antd"
              :requires ["cljsjs.react"
                         "cljsjs.react.dom"])

   (pom)

   (jar)))
