(set-env!
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.10.4")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/phoenix-html
       :version     +version+
       :description "Phoenix.HTML functions for working with HTML strings and templates"
       :url         "https://github.com/phoenixframework/phoenix_html"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/phoenixframework/phoenix_html/archive/v" +lib-version+ ".zip")
             :checksum "4C2DC99F22EDDE193F3D687908B1E4C6"
             :unzip true)
   (sift :move {#"^phoenix_html-.*/priv/static/phoenix_html\.js" "cljsjs/phoenix-html/development/phoenix_html.inc.js"})

   (minify :in "cljsjs/phoenix-html/development/phoenix_html.inc.js"
           :out "cljsjs/phoenix-html/production/phoenix_html.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.phoenix-html" :no-externs true)
   (pom)
   (jar)))
