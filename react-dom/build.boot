(def react-version "0.14.0")
(def +version+ (str react-version "-1"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies [['adzerk/bootlaces   "0.1.9" :scope "test"]
                 ['cljsjs/boot-cljsjs "0.5.0" :scope "test"]
                 ['cljsjs/react       +version+]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(bootlaces! +version+)

(def urls
  {:dom {:dev (str "http://fb.me/react-dom-" react-version ".js")
         :dev-checksum "5F65D8A76B0C66B5A2FA7E6C931FDE26"
         :min (str "http://fb.me/react-dom-" react-version ".min.js")
         :min-checksum "4863AACB9D45FB636C6F9C7E8A98457A"}})

(task-options!
 pom  {:project     'cljsjs/react-dom
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
    (sift :move {(re-pattern (str "^react-dom-" react-version ".js$"))     "cljsjs/react-dom/development/react-dom.inc.js"
                 (re-pattern (str "^react-dom-" react-version ".min.js$")) "cljsjs/react-dom/production/react-dom.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react.dom" :requires ["cljsjs.react"])))
