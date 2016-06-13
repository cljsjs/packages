(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]
                  [cljsjs/react "15.1.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.6.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom { :project     'cljsjs/victory
       :version     +version+
       :description "victory.js collection of composable React components for building interactive data visualizations"
       :url         "http://victory.formidable.com"
       :scm         { :url "https://github.com/FormidableLabs/victory" }
       :license     { "MIT" "https://github.com/FormidableLabs/victory/blob/master/LICENSE.txt" }})

(deftask package []
  (comp
    (download :url (format "https://github.com/FormidableLabs/victory/archive/v%s.zip" +lib-version+)
              :checksum "301569CD68FC91183B07EA358AB1575B"
              :unzip true)
    (sift :move { #"^victory-.*/dist/victory\.js$"      "cljsjs/victory/development/victory.inc.js"
                  #"^victory-.*/dist/victory\.min\.js$" "cljsjs/victory/production/victory.min.inc.js" })
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.victory"
               :requires ["cljsjs.react"])
    (pom)
    (jar)))
