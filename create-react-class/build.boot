(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.9.0" :scope "test"]
                  [cljsjs/react "15.6.1-2"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "15.6.2")
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
              :target "cljsjs/create-react-class/development/create-react-class.inc.js")
    (download :url (format "https://unpkg.com/create-react-class@%s/create-react-class.min.js" +lib-version+)
              :target "cljsjs/create-react-class/production/create-react-class.min.inc.js")
    (deps-cljs :provides ["cljsjs.create-react-class" "create-react-class"]
               :requires ["react"]
               :global-exports '{create-react-class createReactClass})
    (pom)
    (jar)
    (validate-checksums)))
