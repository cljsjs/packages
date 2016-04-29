(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.5.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/mousetrap
       :version     +version+
       :description "Simple library for handling keyboard shortcuts in Javascript"
       :url         "https://craig.is/killing/mice"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache 2.0" "http://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/ccampbell/mousetrap/archive/%s.zip" +lib-version+)
              :checksum "adf961e5d4aa2f330fb18876804271d7"
              :unzip true)
    (sift :move {#"^mousetrap-([\d\.]*)/mousetrap\.js"      "cljsjs/mousetrap/development/mousetrap.inc.js"
                 #"^mousetrap-([\d\.]*)/mousetrap\.min\.js" "cljsjs/mousetrap/production/mousetrap.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.mousetrap")
    (pom)
    (jar)))
