(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/cortical-io
       :version     +version+
       :description "Interface for Cortical-io natural language processing"
       :url         "http://cortical.io/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Custom" "https://github.com/cortical-io/RetinaSDK.js/blob/master/LICENSE.txt"}})

(deftask package []
  (comp
   (download :url (str "https://raw.githubusercontent.com/cortical-io/RetinaSDK.js/master/dist/retina-sdk-"
                       +lib-version+ ".js")
             :checksum "CD977A4ED9A9DE41DC91D635C7669B18")
   (download :url (str "https://raw.githubusercontent.com/cortical-io/RetinaSDK.js/master/dist/retina-sdk-"
                       +lib-version+ ".min.js")
             :checksum "0BA13423AB123F7BEA423EFF664736DD")
   (sift :move {(re-pattern (str "^retina-sdk-" +lib-version+ ".js$"))
                "cljsjs/cortical-io/development/cortical-io.inc.js"
                (re-pattern (str "^retina-sdk-" +lib-version+ ".min.js$"))
                "cljsjs/cortical-io/production/cortical-io.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.cortical-io")
   (pom)
   (jar)))
