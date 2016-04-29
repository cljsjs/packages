(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "7.0.1")
(def +version+ (str +lib-version+ ""))

(task-options!
 pom  {:project     'cljsjs/chemdoodle
       :version     +version+
       :description "A JavaScript Chemostry Visualization Library"
       :url         "http://web.chemdoodle.com/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"GPL" "http://www.gnu.org/copyleft/gpl.html"}})

(deftask package []
  (comp
    (download :url (str "http://web.chemdoodle.com/downloads/ChemDoodleWeb-" +lib-version+ ".zip")
              :checksum "a080e2b2a701321b35ceaa5655d2c876"
              :unzip true)
    (sift :move {#"^ChemDoodleWeb-([\d\.]*)/src/ChemDoodleWeb-unpacked.js"
                 "cljsjs/chemdoodle/development/chemdoodle.inc.js"

                 #"^ChemDoodleWeb-([\d\.]*)/install/ChemDoodleWeb.css"
                 "cljsjs/chemdoodle/common/ChemDoodleWeb.css"

                 #"^ChemDoodleWeb-([\d\.]*)/install/ChemDoodleWeb.js"
                 "cljsjs/chemdoodle/production/chemdoodle.min.inc.js"
                 })
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.chemdoodle")
    (pom)
    (jar)))

