(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.8.6")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/showdown
      :version     +version+
      :description "A Markdown to HTML converter written in Javascript"
      :url         "https://github.com/showdownjs/showdown"
      :scm         {:url "https://github.com/showdownjs/showdown"}
      :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(defn download-url
  [min?]
  (format "https://unpkg.com/showdown@%s/dist/showdown.%sjs" +lib-version+ (if min? "min." "")))

(deftask package []
  (comp
   (download :url (download-url false) :name "showdown.js")
   (download :url (download-url true)  :name "showdown.min.js")
   (sift      :move     {#"showdown.js" "cljsjs/showdown/development/showdown.inc.js"
                         #"showdown.min.js" "cljsjs/showdown/production/showdown.min.inc.js"})
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.showdown")
   (pom)
   (jar)
   (validate)))
