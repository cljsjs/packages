(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/rbush
       :version     +version+
       :description (str "A high-performance JavaScript library for 2D spatial indexing of points and rectangles.")
       :url         "https://github.com/mourner/rbush"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/rbush@%s/rbush.js" +lib-version+)
             :target "cljsjs/rbush/development/rbush.inc.js")
   (download :url (format "https://unpkg.com/rbush@%s/rbush.min.js" +lib-version+)
             :target "cljsjs/rbush/production/rbush.min.inc.js")
   (deps-cljs :name "cljsjs.rbush"
              :global-exports '{cljsjs.rbush rbush}
              )
   (pom)
   (jar)
   (validate-checksums)))
