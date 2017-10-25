(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.8.1" :scope "test"]
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
   (download :url (str "https://unpkg.com/react-xmasonry@ " +lib-version+ "/dist/index.js")
             :checksum "0EBBB8D60FFC450A9BB625B49B2D0F0F")
   (sift :move {#"^index.js$"  "cljsjs/react-xmasonry/common/react-xmasonry.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.react-xmasonry" :requires ["cljsjs.react"])
   (pom)
   (jar)))
