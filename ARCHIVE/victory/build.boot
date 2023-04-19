(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]
                  [cljsjs/react "15.6.2-0"]
                  [cljsjs/prop-types "15.6.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.24.2")
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

    (download :url "https://cdnjs.cloudflare.com/ajax/libs/victory/0.24.2/victory.js"
              :checksum "db8c6f77b988a983152432b0b5cb7f19")
    (download :url "https://cdnjs.cloudflare.com/ajax/libs/victory/0.24.2/victory.min.js"
              :checksum "064354b2c2f45fc46bb002f47e2bfc54")

    (sift :move {#"^victory\.js"       "cljsjs/victory/development/victory.inc.js"
                 #"^victory\.min.\.js" "cljsjs/victory/production/victory.min.inc.js"})

    (sift :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.victory"
               :requires ["cljsjs.react" "cljsjs.prop-types"])

    (pom)
    (jar)))
