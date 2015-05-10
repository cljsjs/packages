(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.11" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.7" :scope "test"]
                  [cljsjs/d3 "3.5.5-3"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def vega-version "1.5.0")
(def vega2-version "2.0.0-dev")

(def +version+ (str vega-version "-0"))
(bootlaces! +version+)

(def urls
  {:normal {:min "https://trifacta.github.io/vega/vega.min.js"
            :min-checksum "3B3911D7A386604A44121A761DE7C481"
            :dev "https://trifacta.github.io/vega/vega.js"
            :dev-checksum "DB92B93B72FF0E61837810F189903227"}})

(def urls2
  {:normal {:min "https://raw.githubusercontent.com/uwdata/vega/v2/vega2.min.js"
            :min-checksum "580A3CF6564FFC65F155E9A603F7984C"
            :dev "https://raw.githubusercontent.com/uwdata/vega/v2/vega2.js"
            :dev-checksum "E1C9BC6D82B430E19D796A659B960815"}})

(task-options!
  pom {:project     'cljsjs/vega
       :version     +version+
       :description "Vega is a declarative format for creating, saving, and sharing visualization designs"
       :url         "https://vega.github.io/"
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (task-options! push {:ensure-branch nil})
  (comp
    (download :url (-> urls :normal :dev) :checksum (-> urls :normal :dev-checksum))
    (download :url (-> urls :normal :min) :checksum (-> urls :normal :min-checksum))
    (sift :move {#"^vega.js$" "cljsjs/development/vega.inc.js"
                 #"^vega.min.js$" "cljsjs/production/vega.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.vega"
               :requires ["cljsjs.d3"])))
