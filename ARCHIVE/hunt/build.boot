(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.1.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  push {:ensure-clean false}
  pom  {:project     'cljsjs/hunt
        :version     +version+
        :description "Library to detect when DOM elements become visible and disappear on scroll"
        :url         "https://jeremenichelli.github.io/hunt"
        :license     {"MIT" "http://opensource.org/licenses/MIT"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  ;;(task-options! push {:ensure-branch nil})
  (comp
    (download :url (format "https://github.com/jeremenichelli/hunt/archive/v%s.zip" +lib-version+)
              :checksum "84319155bb059c3805814298f8e7cceb"
              :unzip true)
    (sift :move {#"^hunt-[^\/]*/dist/hunt\.min\.js" "cljsjs/production/hunt.inc.js"
                 #"^hunt-[^\/]*/dist/hunt\.js" "cljsjs/development/hunt.inc.js"})

    (sift :include #{#"^cljsjs" #"^deps\.cljs"})
    (pom)
    (jar)))
