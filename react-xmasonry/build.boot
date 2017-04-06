(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/react-xmasonry
        :version     +version+
        :description "React Stack Grid"
        :url         "https://github.com/tsuyoshiwada/react-xmasonry"
        :license     {"MIT" "https://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (format "https://github.com/ZitRos/react-xmasonry/archive/master.zip")
             :checksum "E6B128183607A37A561E58E5D913CF4C"
             :unzip true)

   (sift :move {#"^react-xmasonry-.*/dist/index.js"  "cljsjs/react-xmasonry/common/react-xmasonry.inc.js"})

   (sift :include #{#"^cljsjs"})

   (deps-cljs :name "cljsjs.react-xmasonry")
   (pom)
   (jar)))
