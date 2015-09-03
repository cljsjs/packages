(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                 [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.12.1")
(def cljsjs-version "0")

(task-options!
 pom  {:project     'cljsjs/selectize
       :version     (str +version+ "-" cljsjs-version)
       :description "Selectize is the hybrid of a textbox and <select> box."
       :url         "http://brianreavis.github.io/selectize.js/"
       :scm         {:url "https://github.com/brianreavis/selectize.js/"}
       :license     {"Apache v2" "http://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/brianreavis/selectize.js/archive/v" +version+ ".zip")
             :checksum "FED9044122798910DCB637E90E96E462"
             :unzip true)
   (sift :move {#".*/dist/js/standalone/selectize.js"     "cljsjs/selectize/development/selectize.inc.js"
                #".*/dist/js/standalone/selectize.min.js" "cljsjs/selectize/production/selectize.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.selectize")))
