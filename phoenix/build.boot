(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.3.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/phoenix
       :version     +version+
       :description "Phoenix Elixir Framework client"
       :url         "http://www.phoenixframework.org"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/phoenixframework/phoenix/archive/v" +lib-version+ ".zip")
             :checksum "D47A5872A9FBFCE084FE7571A09B9AAD"
             :unzip true)
   (sift :move {#"^phoenix-.*/priv/static/phoenix\.js" "cljsjs/phoenix/development/phoenix.inc.js"})

   (minify :in "cljsjs/phoenix/development/phoenix.inc.js"
           :out "cljsjs/phoenix/production/phoenix.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.phoenix")
   (pom)
   (jar)))
