(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.2"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.4.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/showdown
      :version     +version+
      :description "A Markdown to HTML converter written in Javascript"
      :url         "https://github.com/showdownjs/showdown"
      :scm         {:url "https://github.com/showdownjs/showdown"}
      :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
   (download  :url      (format "https://github.com/showdownjs/showdown/archive/%s.zip" +lib-version+)
              :checksum "f751bf13b596ecd63af58bf598a606ec"
              :unzip    true)
   (sift      :move     {#"^showdown.*[/ \\]dist[/ \\]showdown.js$"
                         "cljsjs/showdown/development/showdown.inc.js"
                         #"^showdown.*[/ \\]dist[/ \\]showdown.min.js"
                         "cljsjs/showdown/production/showdown.min.inc.js"})
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.showdown")
   (pom)
   (jar)))
