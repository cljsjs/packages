(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]
                  [cljsjs/react "15.4.2-2"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.1")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  pom  {:project     'cljsjs/react-xmasonry
        :version     +version+
        :description "React Masonry"
        :url         "https://github.com/tsuyoshiwada/react-xmasonry"
        :license     {"MIT" "https://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (format "https://github.com/ZitRos/react-xmasonry/archive/master.zip")
             :checksum "D9F26537EB811BC06717D08A93E58235"
             :unzip true)
   (sift :move {#"^react-xmasonry-.*/dist/index.js"  "cljsjs/react-xmasonry/common/react-xmasonry.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.react-xmasonry" :requires ["cljsjs.react"])
   (pom)
   (jar)))
