(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.2")
; FIXME: Next release should have proper build identier
(def +version+ (str +lib-version+ ".0"))

(task-options!
 pom  {:project     'cljsjs/kemia
       :version     +version+
       :description "A chemical structure library"
       :url         "http://kemia.github.io/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache" "http://www.apache.org/licenses/"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/kemia/kemia/archive/v%s.zip" +lib-version+)
              :checksum "DED3B45E53C56188758F964EDAB08344"
              :unzip true)
    (sift :move {#"^kemia-([\d\.]*)/kemia/" "cljsjs/kemia/development/"
                 #"^kemia-([\d\.]*)/css/kemia.css" "cljsjs/kemia/common/kemia.inc.css"})
    (sift :include #{#"^cljsjs/" #"deps.cljs"})))

