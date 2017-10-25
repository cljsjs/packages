(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.8.1" :scope "test"]
                 [cljsjs/react "15.6.1-1"]
                 [cljsjs/react-dom "15.6.1-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.13.4")
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
             :checksum "6ba56675c379ab9f056772913c8e8d28"
             :unzip false)

   (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/antd/" +lib-version+ "/antd-with-locales.min.js")
             :checksum "e1855fa83794269b313c7ba8faf438b5"
             :unzip false)

   (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/antd/" +lib-version+ "/antd.css")
             :checksum "3620ec50632e6b075af99b9fb12a3fa3"
             :unzip false)

   (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/antd/" +lib-version+ "/antd.min.css")
             :checksum "8e9b3483d5657af950de4450df1298a0"
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
