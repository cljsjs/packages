(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]
                 [cljsjs/react "16.6.0-0"]
                 [cljsjs/react-dom "16.6.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.1.1")
(def +version+ (str +lib-version+ "-0"))

;;(def url-prefix (str "https://unpkg.com/ant-design-pro@" +lib-version+))
(def url-prefix (str "https://cdnjs.cloudflare.com/ajax/libs/ant-design-pro/" +lib-version+))

(task-options!
 push {:ensure-clean false}
 pom {:project     'cljsjs/ant-design-pro
      :version     +version+
      :description "One design language http://pro.ant.design"
      :url         "https://github.com/ant-design/ant-design-pro"
      :license     {"MIT" "https://raw.githubusercontent.com/ant-design/ant-design-pro/master/LICENSE"}
      :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download
    :url (str url-prefix "/ant-design-pro.css")
    :unzip false)
   (download
    :url (str url-prefix "/ant-design-pro.min.css")
    :unzip false)
   (download
    :url (str url-prefix "/ant-design-pro.js")
    :unzip false)
   (download
    :url (str url-prefix "/ant-design-pro.min.js")
    :unzip false)
   (replace-content :in "ant-design-pro.js" :match #"ant-design-pro" :value "AntDesignPro")
   (replace-content :in "ant-design-pro.min.js" :match #"ant-design-pro" :value "AntDesignPro")
   (sift
    :move {#"^ant-design-pro.js$" "cljsjs/ant-design-pro/development/ant-design-pro.inc.js"
           #"^ant-design-pro.min.js$" "cljsjs/ant-design-pro/production/ant-design-pro.min.inc.js"
           #"^ant-design-pro.css$" "cljsjs/ant-design-pro/development/ant-design-pro.inc.css"
           #"^ant-design-pro.min.css$" "cljsjs/ant-design-pro/production/ant-design-pro.min.inc.css"})
   (sift :include #{#"cljsjs"})
   (deps-cljs
    :provides ["ant-design-pro" "cljsjs.ant-design-pro"]
    :requires ["react" "react-dom"]
    :global-exports '{ant-design-pro AntDesignPro})
   (pom)
   (jar)
   (validate)))
