(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "15.5.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/create-react-class
       :version     +version+
       :description "A drop-in replacement for React.createClass."
       :url         "http://facebook.github.io/react/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
    (download :url (format "https://unpkg.com/create-react-class@%s/create-react-class.js" +lib-version+)
              :checksum "F540B0C0B88706670CD68BDDBE2359EB")
    (download :url (format "https://unpkg.com/create-react-class@%s/create-react-class.min.js" +lib-version+)
              :checksum "6B58900A387DD9701204ECFB2FD3D8EE")
    (sift :move {#"^create-react-class\.js$"      "cljsjs/create-react-class/development/create-react-class.inc.js"
                 #"^create-react-class\.min\.js$" "cljsjs/create-react-class/development/create-react-class.min.inc.js"})
    (deps-cljs :name "cljsjs.create-react-class"
               :requires ["cljsjs.react"])
    (pom)
    (jar)))
