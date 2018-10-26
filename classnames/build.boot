(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.2.5")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/classnames
       :version     +version+
       :description "A simple javascript utility for conditionally joining classNames together"
       :url         "https://github.com/JedWatson/classnames"
       :scm         {:url "https://github.com/JedWatson/classnames"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/JedWatson/classnames/archive/v" +lib-version+ ".zip")
             :unzip    true)
   (sift     :move     {(re-pattern (str "^classnames-" +lib-version+ "/index.js"))
                        "cljsjs/development/classnames.inc.js"})
   (minify   :in       "cljsjs/development/classnames.inc.js"
             :out      "cljsjs/production/classnames.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.classnames"
              :provides ["classnames" "cljsjs.classnames"]
              :global-exports '{classnames classNames})
   (pom)
   (jar)
   (validate-checksums)))
