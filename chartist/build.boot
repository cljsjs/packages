(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.9.4")
(def +version+ (str +lib-version+ "-2"))

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
              :checksum "01FE7D257F4397EB1F216622797F951D")
    (download :url (github "chartist.min.js")
              :checksum "D7870B3EE02F8528E183E5492B1456BE")
    (download :url (github "chartist.min.js.map")
              :checksum "A61ACCBD9AADDBE40D27AF7563D4E576")
    (download :url (github "chartist.min.css")
              :checksum "0DD8D6C6DCA261528D9BE38904D656D3")
    (sift :move
          {#"chartist.js" "cljsjs/development/chartist.inc.js"
           #"chartist.min.js" "cljsjs/production/chartist.min.inc.js"
           #"chartist.min.js.map" "cljsjs/production/chartist.min.inc.js.map"
           #"chartist.min.css" "cljsjs/common/chartist.min.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.chartist")))
