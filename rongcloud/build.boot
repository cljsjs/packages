(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.9.10-0")

(task-options!
 pom  {:project     'cljsjs/rongcloud
       :version     +version+
       :description "Web (JavaScript) IM SDK of RongCloud."
       :url         "https://github.com/rongcloud/rongcloud-web-im-sdk"
       :scm         {:url "https://github.com/cljsjs/packages"}
       })

(deftask package []
  (comp
    ;(download :url "https://raw.githubusercontent.com/rongcloud/rongcloud-web-im-sdk/master/dest/RongIMClient.js"
    ;          :checksum "5493CB844C0A73BB752EBB422E11547A"
    ;          :unzip false)
    ;(download :url "https://raw.githubusercontent.com/rongcloud/rongcloud-web-im-sdk/master/dest/RongIMClient.min.js"
    ;          :checksum "A4C42981A728720DAE5E532270D77B05"
    ;          :unzip false)
    ;(sift :move {#"^RongIMClient.js-\d\.\d\.\d/RongIMClient.js"     "cljsjs/development/rongcloud.inc.js"
    ;             #"^RongIMClient.js-\d\.\d\.\d/RongIMClient.min.js" "cljsjs/production/rongcloud.min.inc.js"})
    ;(replace-content :in "cljsjs/production/rongcloud.min.inc.js" :match #"(?m)^//# sourceMappingURL=.*$" :value "")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.rongcloud")))
