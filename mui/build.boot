(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.11" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def mui-version "0.1.8")
(def +version+ (str mui-version "-0"))
(bootlaces! +version+)

(def urls
  {:normal {:dev (str "http://cdn.muicss.com/mui-" mui-version "/js/mui.js")
            :dev-checksum "5FF973BFB4FD4C9318738EFADD890895"
            :min (str "http://cdn.muicss.com/mui-" mui-version "/js/mui.min.js")
            :min-checksum "455A8EC05A55093D00FD604122DC92B0"
            :css (str "http://cdn.muicss.com/mui-" mui-version "/css/mui.min.css")
            :css-checksum "A858727D4F7EE0A3F4B357C65A8FBBA6"}})

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
    (download :url (-> urls :normal :dev) :checksum (-> urls :normal :dev-checksum))
    (download :url (-> urls :normal :min) :checksum (-> urls :normal :min-checksum))
    (download :url (-> urls :normal :css) :checksum (-> urls :normal :css-checksum))
    (sift :move {#"^mui.js$" "cljsjs/development/mui.inc.js"
                 #"^mui.min.js$" "cljsjs/production/mui.min.inc.js"
                 #"^mui.min.css$" "cljsjs/common/mui.min.inc.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.mui" :no-externs true)))
