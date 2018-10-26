(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.2.2")
(def +version+ (str +lib-version+ "-0"))
(def sha "63a5c7795e15c2422a82a41354eae486049d6f1f")

(task-options!
 pom  {:project     'cljsjs/xpath-dom
       :version     +version+
       :description "Easily use XPath with the DOM"
       :url         "https://github.com/johannhof/xpath-dom"
       :scm         {:url "https://github.com/johannhof/xpath-dom"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download  :url      (format "https://github.com/johannhof/xpath-dom/archive/%s.zip" sha)
              :checksum "6830B35833DD37461F9D4588ED2A945C"
              :unzip    true)
   (sift      :move     {#"^xpath-dom(.*)/dist/xpath-dom.min.js" "cljsjs/xpath-dom/common/xpath-dom.inc.js"})
   (sift      :include  #{#"^cljsjs"})
   (deps-cljs :name     "cljsjs.xpath-dom")
   (pom)
   (jar)))
