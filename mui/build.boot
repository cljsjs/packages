(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.11" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.7" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def mui-version "0.0.5")
(def +version+ (str mui-version "-0"))
(bootlaces! +version+)

(def urls
  {:normal {:min (str "http://cdn.muicss.com/mui-" mui-version "/js/mui.min.js")
            :min-checksum "e486937f427f8eb71a930345d1987670"
            :dev (str "http://cdn.muicss.com/mui-" mui-version "/js/mui.js")
            :dev-checksum "5a003cb1cd33dc96515450fe79ce84e4"
            :css (str "http://cdn.muicss.com/mui-" mui-version "/css/mui.min.css")
            :css-checksum "35df6c80008b7f810a7abb0b78be42d1"}})

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
