(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.2.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/anime
       :version     +version+
       :description "JavaScript animation engine"
       :url         "http://animejs.com/"
       :scm         {:url "https://github.com/juliangarnier/anime"}
       :license     {"MIT" "https://github.com/juliangarnier/anime/blob/v2.2.0/LICENSE.md"}})

(deftask package []
         (comp
          (download  :url      (format "https://github.com/juliangarnier/anime/archive/%s.zip" +lib-version+)
                     :checksum "7EB658E42F5268927E38FD642F925C2C"
                     :unzip    true)
          (sift      :move     {#"^anime(.*)/anime.js"
                                "cljsjs/anime/development/anime.inc.js"
                                #"^anime(.*)/anime.min.js"
                                "cljsjs/anime/production/anime.min.inc.js"})
          (sift      :include  #{#"^cljsjs"})
          (deps-cljs :name     "cljsjs.anime")
          (pom)
          (jar)))