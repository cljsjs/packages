(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.6.5")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/mousetrap-plugins
      :version     +version+
      :description "Simple library for handling keyboard shortcuts in Javascript (include all plugins)"
      :url         "https://craig.is/killing/mice"
      :scm         {:url "https://github.com/cljsjs/packages"}
      :license     {"Apache 2.0" "http://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (comp
   (run-commands :commands [["npm" "install" "--include-dev"]
                            ["npm" "run" "build:dev"]
                            ["npm" "run" "build:prod"]
                            ["rm" "-rf" "./node_modules"]])
   (sift :move {#".*mousetrap-plugins.inc.js"     "cljsjs/mousetrap-plugins/development/mousetrap-plugins.inc.js"
                #".*mousetrap-plugins.min.inc.js" "cljsjs/mousetrap-plugins/production/mousetrap-plugins.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :foreign-libs [{:file           #"mousetrap-plugins.inc.js"
                              :file-min       #"mousetrap-plugins.min.inc.js"
                              :provides       ["mousetrap-plugins" "cljsjs.mousetrap-plugins"]
                              :global-exports '{"mousetrap" "Mousetrap"}}]
              :externs [#"mousetrap-plugins.ext.js"])
   (pom)
   (jar)
   (validate-checksums)))
