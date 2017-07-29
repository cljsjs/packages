(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "15.6.0")
(def +version+ (str +lib-version+ "-1"))

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
              :checksum "8EAD63B362AC03AB2C3AE949CEB50E21")
    (download :url (format "https://unpkg.com/create-react-class@%s/create-react-class.min.js" +lib-version+)
              :checksum "220EE670C19A1C2CDD96E4AE13C7B4F1")
    (sift :move {#"^create-react-class\.js$"      "cljsjs/create-react-class/development/create-react-class.inc.js"
                 #"^create-react-class\.min\.js$" "cljsjs/create-react-class/development/create-react-class.min.inc.js"})
    (pom)
    (jar)))
