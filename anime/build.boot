(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

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
          (download  :url      (str "https://github.com/juliangarnier/anime/archive/v" +lib-version+ ".zip")
                     :checksum "3279689A50F312725D6645C223D8602E"
                     :unzip    true)
          (sift      :move     {#".*anime.js"
                                "cljsjs/anime/development/anime.inc.js"
                                #".*anime.min.js"
                                "cljsjs/anime/production/anime.min.inc.js"})
          (sift      :include  #{#"^cljsjs"})
          (deps-cljs :name     "cljsjs.anime")
          (pom)
          (jar)))
