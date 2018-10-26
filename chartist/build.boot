(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.10.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project 'cljsjs/chartist
       :version +version+
       :description "Chartist.js - Simple responsive charts"
       :url "http://gionkunz.github.io/chartist-js/"
       :license {"MIT" "http://opensource.org/licenses/MIT"}
       :scm {:url "https://github.com/cljsjs/packages"}})

(defn github [file]
  (str "https://raw.githubusercontent.com/gionkunz/chartist-js/v"
       +lib-version+ "/dist/" file))

(deftask package []
  (comp
    (download :url (github "chartist.js")
              :checksum "F4FCB05E839A197B60793890784B9E86")
    (download :url (github "chartist.min.js")
              :checksum "72C8771E35D8C249684DC12AF34204CE")
    (download :url (github "chartist.min.js.map")
              :checksum "598B9192CE5FC96F37B25C1E8AFBEE92")
    (download :url (github "chartist.min.css")
              :checksum "B81B591D12C8A8E72AF2E05F1E62A9EB")
    (sift :move
          {#"chartist.js" "cljsjs/development/chartist.inc.js"
           #"chartist.min.js" "cljsjs/production/chartist.min.inc.js"
           #"chartist.min.js.map" "cljsjs/production/chartist.min.inc.js.map"
           #"chartist.min.css" "cljsjs/common/chartist.min.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.chartist")
    (pom)
    (jar)))
