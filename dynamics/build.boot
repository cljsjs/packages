(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(def +lib-version+ "1.1.5")
(def +version+ (str +lib-version+ "-0"))

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
  pom {:project     'cljsjs/dynamics
       :version     +version+
       :description "The Write Less, Do More, JavaScript Library."
       :url         "http://dynamicsjs.com/"
       :license     {"MIT" "http://opensource.org/licenses/MIT"}
       :scm         {:url "https://github.com/cljsjs/packages"}})
(deftask package []
  (comp
    (download :url (format "https://github.com/michaelvillar/dynamics.js/releases/download/%s/dynamics.js" +lib-version+)
      :checksum "D8AA9AEC6A5DB97E7B80B7C89B670B97")
    (download :url (format "https://github.com/michaelvillar/dynamics.js/releases/download/%s/dynamics.min.js" +lib-version+)
      :checksum "BE960DBB262A36D4599ACF209ABAAEC0")
    (sift :move {#"dynamics.js" "cljsjs/development/dynamics.inc.js"
                 #"dynamics.min.js" "cljsjs/production/dynamics.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.dynamics")
    (pom)
    (jar)))