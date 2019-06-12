(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                 [cljsjs/react "16.8.3-0"]
                 [cljsjs/react-dom "16.8.3-0"]
                 [cljsjs/moment "2.24.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.19.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 push {:ensure-clean false}
 pom {:project     'cljsjs/antd
      :version     +version+
      :description "One design language http://ant.design"
      :url         "https://github.com/ant-design/ant-design"
      :license     {"MIT" "https://raw.githubusercontent.com/ant-design/ant-design/master/LICENSE"}
      :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download
    :url (str "https://cdnjs.cloudflare.com/ajax/libs/antd/"
              +lib-version+
              "/antd-with-locales.js")
    :unzip false)
   (download
    :url (str "https://cdnjs.cloudflare.com/ajax/libs/antd/"
              +lib-version+
              "/antd-with-locales.min.js")
    :unzip false)
   (download
    :url (str "https://cdnjs.cloudflare.com/ajax/libs/antd/"
              +lib-version+
              "/antd.css")
    :unzip false)
   (download
    :url (str "https://cdnjs.cloudflare.com/ajax/libs/antd/"
              +lib-version+
              "/antd.min.css")
    :unzip false)
   (sift
    :move {#"^antd-with-locales.js$" "cljsjs/antd/development/antd.inc.js"
           #"^antd-with-locales.min.js$" "cljsjs/antd/production/antd.min.inc.js"
           #"^antd.css$" "cljsjs/antd/development/antd.inc.css"
           #"^antd.min.css$" "cljsjs/antd/production/antd.min.inc.css"})

   (replace-content
      :in "cljsjs/antd/development/antd.inc.js"
      :match #"\/\/\# sourceMappingURL=performance-now\.js\.map"
      :value "")

   (replace-content
      :in "cljsjs/antd/development/antd.inc.js"
      :match #"\/\/\# sourceMappingURL=antd-with-locales\.js\.map$"
      :value "")

   (replace-content
      :in "cljsjs/antd/production/antd.min.inc.js"
      :match #"\/\/\# sourceMappingURL=antd-with-locales\.min\.js\.map$"
      :value "")

   (sift :include #{#"cljsjs"})
   (deps-cljs
    :provides ["antd" "cljsjs.antd"]
    :requires ["react" "react-dom" "moment"]
    :global-exports '{antd antd})
   (pom)
   (jar)
   (validate)))
