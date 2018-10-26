(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                  [cljsjs/react "15.4.2-2"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.5.3")
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
             :checksum "3785BC71BADBBFB0EA0AF8C967B74F23")
   (sift :move {#"^index.js$"  "cljsjs/react-xmasonry/common/react-xmasonry.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.react-xmasonry" :requires ["cljsjs.react"])
   (pom)
   (jar)))
