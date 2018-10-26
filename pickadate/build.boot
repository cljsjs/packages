(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]
                  [cljsjs/jquery "2.2.2-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.5.6")
(def +version+ (str +lib-version+ "-2"))

(task-options!
  pom {:project 'cljsjs/pickadate
       :version +version+
       :description "The mobile-friendly, responsive, and lightweight jQuery date & time input picker"
       :url         "https://github.com/amsul/pickadate.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/amsul/pickadate.js/archive/" +lib-version+ ".zip")
      :checksum "3AD8AF80E2974F7B5878DD14FA223649"
      :unzip true)
    (sift :move {#"^pickadate.+/themes-source/(.+)\.less$"    "cljsjs/pickadate/development/pickadate-$1.inc.less"
                 #"^pickadate.+/compressed/themes/(.+)\.css$" "cljsjs/pickadate/production/pickadate-$1.min.inc.css"
                 #"^pickadate.+/themes/(.+)\.css$"            "cljsjs/pickadate/development/pickadate-$1.inc.css"
                 #"^pickadate.+/compressed/([^/]+)\.js$"      "cljsjs/pickadate/production/$1.min.inc.js"
                 #"^pickadate.+/lib/([^/]+)\.js$"             "cljsjs/pickadate/development/$1.inc.js"})
    (sift :include #{#"^cljsjs/" #"^deps.cljs$"})
    (pom)
    (jar)))
