(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                 [cljsjs/jquery "1.9.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.2.2")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom {:project     'cljsjs/bootstrap-toggle
      :version     +version+
      :description "Bootstrap Toggle is a highly flexible Bootstrap plugin that converts checkboxes into toggles"
      :url         "http://www.bootstraptoggle.com"
      :scm         {:url "https://github.com/minhur/bootstrap-toggle"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/minhur/bootstrap-toggle/archive/" +lib-version+ ".zip")
             :checksum "cf64ac729a2d9523252ba42dab541fba"
             :unzip true)
   (sift :move {#"^bootstrap-toggle-(.*)/js/bootstrap-toggle.js" "cljsjs/bootstrap-toggle/development/bootstrap-toggle.inc.js"
                #"^bootstrap-toggle-(.*)/js/bootstrap-toggle.min.js" "cljsjs/bootstrap-toggle/production/bootstrap-toggle.min.inc.js"
                #"^bootstrap-toggle-(.*)/css/bootstrap-toggle.min.css" "cljsjs/bootstrap-toggle/common/bootstrap-toggle.min.inc.css"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.bootstrap-toggle"
              :requires ["cljsjs.jquery"])
   (pom)
   (jar)))
