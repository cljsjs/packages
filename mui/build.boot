(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.11" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def mui-version "0.1.21")
(def +version+ (str mui-version "-0"))
(bootlaces! +version+)

(task-options!
  pom {:project     'cljsjs/mui
       :version     +version+
       :description "MUI is a lightweight HTML, CSS and JS framework for sites that follow Google's Material Design guidelines."
       :url         "https://www.muicss.com"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (task-options! push {:ensure-branch nil})
  (comp
    (download :url (str "https://github.com/muicss/mui/archive/" mui-version ".zip")
              :checksum "7CF1BE714B674C3A86796DAB9B8AD42B"
              :unzip true)
    (sift :move {#"^mui-[\d.]+/dist/js/mui\.js$"        "cljsjs/development/mui.inc.js"
                 #"^mui-[\d.]+/dist/js/mui\.min\.js$"   "cljsjs/production/mui.min.inc.js"
                 #"^mui-[\d.]+/dist/css/mui\.min\.css$" "cljsjs/common/mui.min.inc.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.mui" :no-externs true)))
