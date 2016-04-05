(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "6.1.8")
(def +version+ (str +lib-version+ "-1"))

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
      :checksum "A4BE202DC6F33EAF926FC14C7867F032"
      :unzip true)
    (sift :move {#"^bootstrap-slider-(.*)/dist/bootstrap-slider.js"
                 "cljsjs/bootstrap-slider/development/bootstrap-slider.inc.js"

                 #"^bootstrap-slider-(.*)/dist/bootstrap-slider.min.js"
                 "cljsjs/bootstrap-slider/production/bootstrap-slider.min.inc.js"

                 #"^bootstrap-slider-(.*)/dist/css/bootstrap-slider.css"
                 "cljsjs/bootstrap-slider/common/bootstrap-slider.css"

                 #"^bootstrap-slider-(.*)/dist/css/bootstrap-slider.min.css"
                 "cljsjs/bootstrap-slider/common/bootstrap-slider.min.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.bootstrap-slider")
    (pom)
    (jar)))
