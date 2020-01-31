(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.6.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/jsts
       :version     +version+
       :description (str "A javascript port of the Java Topology Suite")
       :url         "http://bjornharrtell.github.io/jsts/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "https://opensource.org/licenses/BSD"
                     "EPL" "https://www.eclipse.org/legal/epl-v10.html"}})

(deftask package []
  (comp
   (download :url
             (format "https://cdn.rawgit.com/bjornharrtell/jsts/gh-pages/%s/jsts.js"
                     +lib-version+)
             :target "cljsjs/jsts/development/jsts.inc.js")
   (download :url
             (format "https://cdn.rawgit.com/bjornharrtell/jsts/gh-pages/%s/jsts.min.js"
                     +lib-version+)
             :target "cljsjs/jsts/production/jsts.min.inc.js")
   (deps-cljs :name "cljsjs.jsts"
              :global-exports '{cljsjs.jsts jsts}
              )
   (pom)
   (jar)
   (validate)))
