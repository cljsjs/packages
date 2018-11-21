(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]
                  [cljsjs/react       "15.3.0-0"]
                  [cljsjs/snapsvg     "0.4.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.1.6")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-burger-menu
       :version     +version+
       :description "An off-canvas sidebar component with a collection of effects and styles using CSS transitions and SVG path animations"
       :url         "https://github.com/negomi/react-burger-menu"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask download-react-burger-menu []
  (download :url      (str "https://github.com/negomi/react-burger-menu/archive/v" +lib-version+ ".zip")
            :checksum "18c5e0ae2a16157c63c80e449a0752fa"
            :unzip    true))

(deftask package []
  (comp
    (download-react-burger-menu)
    (sift :move {#"^react-.*/dist/react-burger-menu.js"
                 "cljsjs/react-burger-menu/development/react-burger-menu.inc.js"
                 #"^react-.*/dist/react-burger-menu.min.js"
                 "cljsjs/react-burger-menu/production/react-burger-menu.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-burger-menu"
               :requires ["cljsjs.react" "cljsjs.snapsvg"])
    (pom)
    (jar)))
