(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.7.0" :scope "test"]
                 [cljsjs/react "15.6.1-1"]
                 [cljsjs/react-dom "15.6.1-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.12.3")
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
             :checksum "8977a7b70ebb70cc252604d728c518ca"
             :unzip false)

   (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/antd/" +lib-version+ "/antd-with-locales.min.js")
             :checksum "53d05c285b8fa63f63a86821ff9146a8"
             :unzip false)

   (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/antd/" +lib-version+ "/antd.css")
             :checksum "68e11e51e9dbb054ce537e9cb14a82b2"
             :unzip false)

   (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/antd/" +lib-version+ "/antd.min.css")
             :checksum "51f40fa10491780e2481ea42698c4846"
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
