(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.1.1")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 push {:ensure-clean false}
 pom  {:project     'cljsjs/kjua
       :version     +version+
       :description "Dynamically generated QR codes for modern browsers"
       :url         "https://larsjung.de/kjua"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  ;;(task-options! push {:ensure-branch nil})
  (comp
   (download :url (format "https://github.com/lrsjng/kjua/archive/v%s.zip" +lib-version+)
             :checksum "79855f89e17867bb7795a61ca9326c46"
             :unzip true)
   (sift :move {#"^kjua-[^\/]*/dist/kjua\.min\.js" "cljsjs/common/kjua.inc.js"})

   (sift :include #{#"^cljsjs" #"^deps\.cljs"})
   (pom)
   (jar)))
