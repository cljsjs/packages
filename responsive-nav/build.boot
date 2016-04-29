(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.39")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/responsive-nav
       :version     +version+
       :description "Responsive navigation plugin without library dependencies and with fast touch screen support."
       :url         "http://responsive-nav.com"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[clojure.java.io :as io])

(deftask package []
         (comp
           (download :url (format "https://github.com/viljamis/responsive-nav.js/archive/%s.zip" +lib-version+)
                     :checksum "091a5afbdaa5c3c3f00c99427a33e888"
                     :unzip true)
           (sift :move {
                        #"^responsive-nav.js-.*/client/dist/responsive-nav.js$"         "cljsjs/responsive-nav/development/responsive-nav.inc.js"
                        #"^responsive-nav.js-.*/client/dist/responsive-nav.min.js$"     "cljsjs/responsive-nav/production/responsive-nav.min.inc.js"

                        #"^responsive-nav.js-.*/client/dist/styles/responsive-nav.css$" "cljsjs/responsive-nav/common/responsive-nav.css"})
           (sift :include #{#"^cljsjs"})
           (deps-cljs :name "cljsjs.responsive-nav")
           (pom)
           (jar)))
