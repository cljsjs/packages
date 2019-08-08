(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]
                  [cljsjs/bootstrap    "3.3.6-1"] ])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.2.0")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  pom  {:project     'cljsjs/bootstrap-treeview
        :version     +version+
        :description "Tree View for Bootstrap"
        :url         "https://github.com/jonmiles/bootstrap-treeview"
        :license     {"Apache" "https://github.com/jonmiles/bootstrap-treeview/blob/master/LICENSE"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (str "https://raw.githubusercontent.com/jonmiles/bootstrap-treeview/v" +lib-version+ "/src/js/bootstrap-treeview.js")
             :checksum "8348004eca6da08ae1ec3a507c95188d")
   (sift :move {#"^bootstrap-treeview\.js" "cljsjs/bootstrap-treeview/development/bootstrap-treeview.inc.js"})
   (minify :in "cljsjs/bootstrap-treeview/development/bootstrap-treeview.inc.js"
           :out "cljsjs/bootstrap-treeview/production/bootstrap-treeview.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.bootstrap-treeview" :requires ["cljsjs.bootstrap"])
   (pom)
   (jar)))
