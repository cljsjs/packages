(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.2.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project     'cljsjs/jointjs
       :version     +version+
       :description "JointJS is a JavaScript diagramming library."
       :url         "https://www.jointjs.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MPL" "http://mozilla.org/MPL/2.0/"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/clientIO/joint/archive/v%s.zip" +lib-version+)
              :unzip true)
    (sift :move {#"^joint-.*/dist/joint\.js"       "cljsjs/jointjs/development/joint.inc.js"
                 #"^joint-.*/dist/joint\.min\.js"  "cljsjs/jointjs/production/joint.min.inc.js"
                 #"^joint-.*/dist/joint\.css"      "cljsjs/jointjs/development/joint.inc.css"
                 #"^joint-.*/dist/joint\.min\.css" "cljsjs/jointjs/production/joint.min.inc.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.jointjs")
    (pom)
    (jar)
    (validate)))
