(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.22.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/skygear
      :version     +version+
      :description "Skygear BaaS JS SDK"
      :url         "https://skygear.io"
      :scm         {:url "https://github.com/SkygearIO/skygear-SDK-JS"}
      :license     {"Apache-2.0" "https://opensource.org/licenses/Apache-2.0"}})

(deftask package []
  (comp
    (download :url (str "http://registry.npmjs.org/skygear/-/skygear-" +lib-version+ ".tgz")
              :checksum "590E735FC77E57D0F3AF2407BE857E78"
              :decompress true
              :archive-format "tar"
              :compression-format "gz")
    (sift :move {#"^.*dist/skygear\.min\.js$" "cljsjs/skygear/common/skygear.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.skygear")
    (pom)
    (jar)))
