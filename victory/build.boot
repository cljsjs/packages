(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.2"  :scope "test"]
                 [cljsjs/react "15.3.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.13.7")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom { :project     'cljsjs/victory
      :version     +version+
      :description "victory.js collection of composable React components for building interactive data visualizations"
      :url         "http://victory.formidable.com"
      :scm         { :url "https://github.com/FormidableLabs/victory" }
      :license     { "MIT" "https://github.com/FormidableLabs/victory/blob/master/LICENSE.txt" }})

(deftask package []
  (comp
   (download :url "https://cdnjs.cloudflare.com/ajax/libs/victory/0.13.7/victory.js"
             :checksum "42d199f9641564d90624d6659c994afc")
   (download :url "https://cdnjs.cloudflare.com/ajax/libs/victory/0.13.7/victory.min.js"
             :checksum "cde5e0f2dfb02507123dbb0615f77c49")
   (sift :move { #"^victory\.js$"     "cljsjs/victory/development/victory.inc.js"
                #"^victory\.min\.js$" "cljsjs/victory/production/victory.min.inc.js" })
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.victory"
              :requires ["cljsjs.react"])
   (pom)
   (jar)))
