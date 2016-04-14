(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.6.8")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/dragula
        :version     +version+
        :description "Drag and drop so simple it hurts"
        :url         "https://github.com/bevacqua/dragula"
        :scm         {:url "https://github.com/cljsjs/packages"}
        :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download
      :url (str "https://github.com/bevacqua/dragula/archive/v" +lib-version+ ".zip")
      :checksum "1E2B698A284C6F4A8C3C9E3F97E1FFFB"
      :unzip true)
    (sift :move {#"^dragula-(.*)/dist/dragula.js"
                 "cljsjs/dragula/development/dragula.inc.js"

                 #"^dragula-(.*)/dist/dragula.min.js"
                 "cljsjs/dragula/production/dragula.min.inc.js"

                 #"^dragula-(.*)/dist/dragula.css"
                 "cljsjs/dragula/common/dragula.css"

                 #"^dragula-(.*)/dist/dragula.min.css"
                 "cljsjs/dragula/common/dragula.min.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.dragula")
    (pom)
    (jar)))
