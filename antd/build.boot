(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]
                 [cljsjs/react "15.4.2-2"]
                 [cljsjs/react-dom "15.4.2-2"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.10.0")
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
             :checksum "335D5349D7E46A894876CD0647BB1B41"
             :unzip false)

   (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/antd/" +lib-version+ "/antd-with-locales.min.js")
             :checksum "E558194F4D54EF9075030E42B1EBBF78"
             :unzip false)

   (sift :move {#"^antd-with-locales.js$"     "cljsjs/antd/development/antd.inc.js"
                #"^antd-with-locales.min.js$" "cljsjs/antd/production/antd.min.inc.js"})

   (sift :include #{#"cljsjs"})

   (deps-cljs :name "cljsjs.antd"
              :requires ["cljsjs.react"
                         "cljsjs.react.dom"])

   (pom)

   (jar)))
