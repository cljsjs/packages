(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.3.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/eccjs
       :version     +version+
       :description "Simple wrapper around SJCL's ECC Implementation"
       :url         "https://github.com/jpillora/eccjs"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/jpillora/eccjs/archive/" +lib-version+ ".zip")
              :unzip true)    
    (sift :move {#".*/dist/0.3/ecc.js" "cljsjs/development/eccjs.inc.js"
                 #".*/dist/0.3/ecc.min.js" "cljsjs/production/eccjs.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.eccjs")
    (pom)
    (jar)))
