(def +lib-version+ "0.14.3")
(def +version+ (str +lib-version+ "-0"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies [['cljsjs/boot-cljsjs "0.5.0" :scope "test"]
                 ['cljsjs/react       (str +lib-version+ "-0")]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def urls
  {:dom {:dev (str "http://fb.me/react-dom-server-" +lib-version+ ".js")
         :dev-checksum "A80477045BF235F1482E39D2CDAD3E73"
         :min (str "http://fb.me/react-dom-server-" +lib-version+ ".min.js")
         :min-checksum "B407F77B24784A3804E19E84685C27AE"}})

(task-options!
 pom  {:project     'cljsjs/react-dom-server
       :version     +version+
       :description "A Javascript library for building user interfaces"
       :url         "http://facebook.github.io/react/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package  []
  (task-options! push {:ensure-branch nil :tag false})
  (comp
    (download :url (-> urls :dom :dev) :checksum (-> urls :dom :dev-checksum))
    (download :url (-> urls :dom :min) :checksum (-> urls :dom :min-checksum))
    (sift :move {(re-pattern (str "^react-dom-server-" +lib-version+ ".js$"))     "cljsjs/react-dom-server/development/react-dom-server.inc.js"
                 (re-pattern (str "^react-dom-server-" +lib-version+ ".min.js$")) "cljsjs/react-dom-server/production/react-dom-server.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react.dom.server" :requires ["cljsjs.react"])))
