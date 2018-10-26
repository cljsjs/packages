(def +lib-version+ "0.8.0")
(def +version+ (str +lib-version+ "-1"))
(def +lib-release+ (second (clojure.string/split +lib-version+ #"\.")))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"]])

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
