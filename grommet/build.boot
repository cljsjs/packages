(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces "0.1.11" :scope "test"]
                  [cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                  [cljsjs/react "15.6.1-0"]
                  [cljsjs/react-dom "15.6.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.7.0")
(def +version+ (str +lib-version+ "-0"))


(task-options!
 pom  {:project     'cljsjs/grommet
       :version     +version+
       :description "The most advanced UX framework for enterprise applications."
       :url         "https://grommet.github.io/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache v2" "https://raw.githubusercontent.com/grommet/grommet/master/LICENSE"}})

(deftask download-grommet []
  (download :url      (format "https://github.com/grommet/grommet-bower/archive/v%s.zip" +lib-version+)
            :checksum "72AA63EA883449A8E6A2D899E0240F70" ;;MD5
            :unzip    true))

(deftask package []
  (comp
    (download-grommet)
    (sift :move {#"^grommet-.*/grommet.js"
                 "cljsjs/grommet/development/grommet.inc.js"

                 #"^grommet-.*/css/grommet.css"
                 "cljsjs/grommet/development/grommet.inc.css"

                 #"^grommet-.*/css/grommet-aruba.css"
                 "cljsjs/grommet/development/grommet-aruba.inc.css"

                 #"^grommet-.*/css/grommet-hpe.css"
                 "cljsjs/grommet/development/grommet-hpe.inc.css"

                 #"^grommet-.*/css/grommet-hpinc.css"
                 "cljsjs/grommet/development/grommet-hpinc.inc.css"

                 #"^grommet-.*/css/grommet.min.css"
                 "cljsjs/grommet/production/grommet.min.inc.css"

                 #"^grommet-.*/css/grommet-aruba.min.css"
                 "cljsjs/grommet/production/grommet-aruba.min.inc.css"

                 #"^grommet-.*/css/grommet-hpe.min.css"
                 "cljsjs/grommet/production/grommet-hpe.min.inc.css"

                 #"^grommet-.*/css/grommet-hpinc.min.css"
                 "cljsjs/grommet/production/grommet-hpinc.min.inc.css"

                 #"^grommet-.*/grommet.min.js"
                 "cljsjs/grommet/production/grommet.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.grommet"
               :requires ["cljsjs.react.dom" "cljsjs.react"])
    (pom)
    (jar)))
