(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/aphrodite
       :version     +version+
       :description "Support for colocating your styles with your JavaScript component."
       :url         "https://github.com/Khan/aphrodite"
       :scm         {:url "https://github.com/Khan/aphrodite"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (format "https://cdnjs.cloudflare.com/ajax/libs/aphrodite/%s/aphrodite.umd.js" +lib-version+)
              :checksum "F3D282930B73FBBC8C8A3518EDBBAD60")
    (download :url (format "https://cdnjs.cloudflare.com/ajax/libs/aphrodite/%s/aphrodite.umd.min.js" +lib-version+)
              :checksum "94803B5F8E1D42BB1D096CCBCE9974A5")
    (sift :move {#"aphrodite\.umd\.js" "cljsjs/aphrodite/development/aphrodite.inc.js"
                 #"aphrodite\.umd\.min\.js" "cljsjs/aphrodite/production/aphrodite.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.aphrodite")
    (pom)
    (jar)))
