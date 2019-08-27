(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.0.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/anime
       :version     +version+
       :description "JavaScript animation engine"
       :url         "http://animejs.com/"
       :scm         {:url "https://github.com/juliangarnier/anime"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
         (comp
          (download :url (format "https://github.com/juliangarnier/anime/archive/v%s.zip" +lib-version+)
                    :unzip true)
          (sift :move {#".*anime.js" "cljsjs/anime/development/anime.inc.js"
                       #".*anime.min.js" "cljsjs/anime/production/anime.min.inc.js"})
          (sift :include #{#"^cljsjs"})
          (deps-cljs :name "cljsjs.anime")
          (pom)
          (jar)
          (validate-checksums)))
