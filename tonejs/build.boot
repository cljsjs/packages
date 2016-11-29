(def +lib-release+ "8")
(def +lib-version+ (str "0." +lib-version+ ".0"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.task.built-in :refer :all])

(task-options!
 pom  {:project     'cljsjs/tonejs
       :version     +lib-version+
       :description "A Web Audio framework for making interactive music in the browser."
       :url         "http://www.tonejs.org/"
       :license     {"MIT" "https://github.com/Tonejs/Tone.js/blob/master/LICENSE.md"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url
             (format "https://raw.githubusercontent.com/Tonejs/Tone.js/r%s/build/Tone.min.js" +lib-release+)
             :checksum
             "4FFBDF59A08A54FF624BCD17D0FF27D4")

    (sift :move {#"^Tone.min.js" "cljsjs/tonejs/development/Tone.inc.js"})
    (sift :move {#"^Tone.ext.js" "cljsjs/tonejs/common/Tone.ext.js"})

  	(sift :include #{#"^cljsjs"})
  	(deps-cljs :name "tonejs")
  	(show)
  	(pom)
	  (jar)))
