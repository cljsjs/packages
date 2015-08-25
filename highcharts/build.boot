(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +app-info+
  {:project     'cljsjs/highcharts
   :description "Create interactive charts easily for your web projects."
   :url         "http://highcharts.com/"
   :license     {"mixed" "http://www.highcharts.com/license"}
   :scm         {:url "https://github.com/cljsjs/packages"}})

(defn- -package [& {:keys [version dev-opts min-opts]}]
  (task-options! pom (assoc +app-info+ :version version))
  (comp
    (download :url (:url dev-opts) :checksum (:checksum dev-opts))
    (download :url (:url min-opts) :checksum (:checksum min-opts))
    (sift :move {#"highcharts.src.js" "cljsjs/development/highcharts.inc.js"
                 #"highcharts.js" "cljsjs/production/highcharts.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.highcharts")))

(defn- highcharts-url [version suffix]
  (str "http://code.highcharts.com/" version "/highcharts" suffix ".js"))

(deftask package-latest []
  (-package
    :version  "4.1.8"
    :dev-opts {:url (highcharts-url "4.1.8" ".src") :checksum "41195C3B6190A9344C5E1EF9F21BDF2F"}
    :min-opts {:url (highcharts-url "4.1.8" nil) :checksum "236BEAA96DBC1413D5D467E418CBFEA8"}))

(deftask package
  "Package the latest known version"
  []
  (package-latest))
