(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.4.4")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/qrcode-generator
       :version     +version+
       :description "QR Code Generator with support for numeric, alphanumeric, and byte modes."
       :url         "https://github.com/kazuhikoarase/qrcode-generator/tree/master/js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://unpkg.com/qrcode-generator@" +lib-version+ "/qrcode.js"))
    (sift :move {#"^qrcode\.js" "cljsjs/qrcode-generator/development/qrcode-generator.inc.js"})
    (sift :include #{#"^cljsjs"})
    (minify :in "cljsjs/qrcode-generator/development/qrcode-generator.inc.js"
            :out "cljsjs/qrcode-generator/production/qrcode-generator.min.inc.js")
    (deps-cljs :name "cljsjs.qrcode-generator")
    (validate-checksums)
    (pom)
    (jar)))
