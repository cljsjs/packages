(def +lib-version+ "13.4.9")
(def +version+ (str +lib-version+ "-0"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.task.built-in :refer :all])

(task-options!
 pom  {:project     'cljsjs/tonejs
       :version     +version+
       :description "A Web Audio framework for making interactive music in the browser."
       :url         "http://tonejs.org/"
       :license     {"MIT" "https://github.com/Tonejs/Tone.js/blob/master/LICENSE.md"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url
             (format "https://cdnjs.cloudflare.com/ajax/libs/tone/%s/Tone.min.js" +lib-version+))
    (sift :move {#"^Tone.min.js" "cljsjs/tonejs/development/Tone.inc.js"})
    (sift :move {#"^Tone.ext.js" "cljsjs/tonejs/common/Tone.ext.js"})
  	(sift :include #{#"^cljsjs"})
  	(deps-cljs :name "tonejs")
  	(show)
  	(pom)
	(jar)
        (validate-checksums)))
