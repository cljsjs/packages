(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2"  :scope "test"]
                  [cljsjs/react "15.3.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.17.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/victory
      :version     +version+
      :description "victory.js collection of composable React components for building interactive data visualizations"
      :url         "http://victory.formidable.com"
      :scm         { :url "https://github.com/FormidableLabs/victory" }
      :license     { "MIT" "https://github.com/FormidableLabs/victory/blob/master/LICENSE.txt" }})

(deftask package []
  (comp

    (download :url "https://cdnjs.cloudflare.com/ajax/libs/victory/0.17.0/victory.js"
              :checksum "881DCF0A61962A75FBE635D36BC68D58")
    (download :url "https://cdnjs.cloudflare.com/ajax/libs/victory/0.17.0/victory.min.js"
              :checksum "3AFC1F085AD962748A84B42001F4D19D")

    (sift :move {#"^victory\.js"       "cljsjs/victory/development/victory.inc.js"
                 #"^victory\.min.\.js" "cljsjs/victory/production/victory.min.inc.js"})

    (sift :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.victory"
               :requires ["cljsjs.react"])

    (pom)
    (jar)))
