(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                  [cljsjs/moment "2.17.1-1"] ;; bump to 2.18.1 when released
                  [cljsjs/react "16.0.0-0"]
                  [cljsjs/react-dom "16.0.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.1.4")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/react-add-to-calendar
        :version     +version+
        :description "A simple and reusable add to calendar button component for React"
        :url         "https://github.com/jasonsalzman/react-add-to-calendar"
        :scm         {:url "https://github.com/cljsjs/packages"}
        :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[clojure.java.io :as io])

(deftask package []
  (comp
    (download :url      (format "https://registry.npmjs.org/react-add-to-calendar/-/react-add-to-calendar-%s.tgz" +lib-version+)
              :checksum "23de839f08cb336999e7f5f08ef62a61"
              :decompress true
              :compression-format "gz"
              :archive-format "tar")
    (sift :move {#"^.*/dist/react-add-to-calendar.js" "cljsjs/react-add-to-calendar/development/react-add-to-calendar.inc.js"
                 #"^.*/dist/react-add-to-calendar.min.js" "cljsjs/react-add-to-calendar/production/react-add-to-calendar.min.inc.js"
                 #"^.*/dist/react-add-to-calendar.css" "cljsjs/react-add-to-calendar/common/react-add-to-calendar.inc.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-add-to-calendar"
               :requires ["cljsjs.moment"
                          "cljsjs.react"
                          "cljsjs.react.dom"])
    (pom)
    (jar)))
