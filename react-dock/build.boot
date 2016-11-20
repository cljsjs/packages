(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.2"  :scope "test"]
                 [cljsjs/react "0.13.3-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "0.2.3")
(def +version+ (str +lib-version+ "-0"))
(def sha "4eab4eaa2bb021d693454d75014635194e06a13d")

(task-options!
 pom  {:project     'cljsjs/react-dock
       :version     +version+
       :description "Resizable dockable react component"
       :url         "https://github.com/alexkuz/react-dock"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask build-react-dock-mixin []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap
      fileset
      ;; Copy all files in fileset to temp directory
      (doseq [f (->> fileset boot/input-files)
              :let [target (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (binding [boot.util/*sh-dir* (str (io/file tmp (str "react-dock-" sha)))]
        ((sh "npm" "install"))
        ((sh "npm" "install" "browserify"))
        ((sh "npm" "install" "babel-cli"))
        ((sh "npm" "install" "react" "react-dom" "webpack" "babel-loader" "babel-core" "babel-preset-react" "babel-preset-es2015" "babel-preset-stage-0" "babel-plugin-add-module-exports" "less" "babel-plugin-transform-decorators-legacy" "lodash.debounce"))
        ((sh "npm" "run" "build-lib"))
        ((sh "node" "node_modules/browserify/bin/cmd.js" "lib/index.js" "-s" "Dock" "-o" "dock.js")))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
   (download :url (format "https://github.com/alexkuz/react-dock/archive/%s.zip" sha)
             :checksum "7B77669B9BC6C4B3B5BED3639CED3F72"
             :unzip true)
   (build-react-dock-mixin)
   (sift :move {#"^react(.*)/dock.js" "cljsjs/react-dock/development/react-dock.inc.js"})
   (minify :in "cljsjs/react-dock/development/react-dock.inc.js"
           :out "cljsjs/react-dock/production/react-dock.min.inc.js"
           :lang :ecmascript5)
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.react-dock" :requires ["cljsjs.react" "cljsjs.lodash"])
   (pom)
   (jar)))
