(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "7.0.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/bootstrap-slider
        :version     +version+
        :description "JavaScript Library for slider input fields"
        :url         "https://github.com/seiyria/bootstrap-slider"
        :scm         {:url "https://github.com/cljsjs/packages"}
        :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download
      :url (str "https://github.com/seiyria/bootstrap-slider/archive/v" +lib-version+ ".zip")
      :checksum "BE79D8D2795A250252EE44BCD525ED99"
      :unzip true)
    (sift :move {#"^bootstrap-slider-.*/dist/bootstrap-slider.js"
                 "cljsjs/bootstrap-slider/development/bootstrap-slider.inc.js"

                 #"^bootstrap-slider-.*/dist/bootstrap-slider.min.js"
                 "cljsjs/bootstrap-slider/production/bootstrap-slider.min.inc.js"

                 #"^bootstrap-slider-.*/dist/css/bootstrap-slider.css"
                 "cljsjs/bootstrap-slider/common/bootstrap-slider.css"

                 #"^bootstrap-slider-.*/dist/css/bootstrap-slider.min.css"
                 "cljsjs/bootstrap-slider/common/bootstrap-slider.min.css"

                 #"^bootstrap-slider-.*/src/less/(.*)\.less$"
                 "cljsjs/bootstrap-slider/common/$1.less"

                 #"^bootstrap-slider-.*/src/sass/(.*)\.scss$"
                 "cljsjs/bootstrap-slider/common/$1.scss"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.bootstrap-slider")
    (pom)
    (jar)))
