(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]
                 [cljsjs/jquery "1.9.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.12.1")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/selectize
       :version     +version+
       :description "Selectize is the hybrid of a textbox and <select> box."
       :url         "http://brianreavis.github.io/selectize.js/"
       :scm         {:url "https://github.com/brianreavis/selectize.js/"}
       :license     {"Apache v2" "http://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/brianreavis/selectize.js/archive/v" +lib-version+ ".zip")
             :checksum "FED9044122798910DCB637E90E96E462"
             :unzip true)
   (sift :move {#".*/dist/js/standalone/selectize.js"     "cljsjs/selectize/development/selectize.inc.js"
                #".*/dist/js/standalone/selectize.min.js" "cljsjs/selectize/production/selectize.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.selectize"
              :requires ["cljsjs.jquery"])
   (pom)
   (jar)))
