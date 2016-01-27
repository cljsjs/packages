(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer [download]])

(def +lib-version+ "1.1.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project 'cljsjs/pdfjs
       :version +version+
       :description "PDF Reader in JavaScript"
       :url         "https://github.com/mozilla/pdf.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache" "http://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/mozilla/pdf.js/releases/download/v%s/pdfjs-%s-dist.zip" +lib-version+ +lib-version+)
              :checksum "E25EE439EDC685D83C2D093CEC964A32"
              :unzip true)
    (sift :move {#"^build/pdf\.js$"         "cljsjs/pdfjs/common/pdf.inc.js"
                 #"^build/pdf\.worker\.js$" "cljsjs/pdfjs/common/pdf.worker.inc.js"
                 #"^web/viewer\.css$"       "cljsjs/pdfjs/common/viewer.css"
                 #"^web/(.*)\.js"           "cljsjs/pdfjs/common/$1.inc.js"
                 #"^web/locale/"            "cljsjs/pdfjs/common/locale/"
                 #"^web/images/"            "cljsjs/pdfjs/common/images/"})
    (sift :include #{#"^cljsjs/" #"^deps\.cljs$"})))
