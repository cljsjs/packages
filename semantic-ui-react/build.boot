(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]
                  [cljsjs/react "15.0.0-0"]
                  [cljsjs/react-dom "15.0.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "0.68.2")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "semantic-ui-react-%s" +lib-version+))

(task-options!
  pom {:project     'cljsjs/semantic-ui-react
       :version     +version+
       :description "React components for Semantic UI"
       :url         "http://react.semantic-ui.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(def url (format "https://unpkg.com/semantic-ui-react@%s/dist/umd/semantic-ui-react.min.js" +lib-version+))

(deftask download-semantic-ui-react []
  (download :url      url
            :checksum "AAEA389692EEAD8B8A086E96CE7040BC"))

(deftask package []
  (comp
    (download-semantic-ui-react)
    (sift :move {#"semantic-ui-react.min.js"
                 "cljsjs/semantic-ui-react/common/semantic-ui-react.inc.js"})
    (deps-cljs :name "cljsjs.semantic-ui-react"
               :requires ["cljsjs.react"
                          "cljsjs.react.dom"])
    (pom)
    (jar)))
