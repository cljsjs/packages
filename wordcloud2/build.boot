(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.2.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/wordcloud2
       :version     +version+
       :description "Create a tag cloud/Wordle presentation on 2D canvas or HTML."
       :url         "https://wordcloud2-js.timdream.org/#"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://github.com/timdream/wordcloud2.js/blob/gh-pages/LICENSE"}})

(deftask package []
  (comp
   (download :url (format "https://cdnjs.cloudflare.com/ajax/libs/wordcloud2.js/%s/wordcloud2.js" +lib-version+)
             :target "cljsjs/wordcloud2/development/wordcloud2.inc.js")
   (download :url (format "https://cdnjs.cloudflare.com/ajax/libs/wordcloud2.js/%s/wordcloud2.min.js" +lib-version+)
             :target "cljsjs/wordcloud2/production/wordcloud2.min.inc.js")
   (deps-cljs :provides ["wordcloud2" "cljsjs.wordcloud2"]
              :global-exports '{WordCloud WordCloud})
   (pom)
   (jar)
   (validate-checksums)))
