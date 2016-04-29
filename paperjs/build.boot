(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.9.24")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/paperjs
       :version     +version+
       :description "The Swiss Army Knife of Vector Graphics Scripting"
       :url         "http://paperjs.org"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/paperjs/paper.js/archive/v" +lib-version+ ".zip")
              :checksum "36FC91B3438A8967D1231876F731E918"
              :unzip true)
    (sift :move {#"^paper.js-.*/dist/paper-full.js" "cljsjs/development/paper-full.inc.js"
                 #"^paper.js-.*/dist/paper-full.min.js" "cljsjs/production/paper-full.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.paperjs")
    (pom)
    (jar)))
