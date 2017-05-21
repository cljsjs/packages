(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2"  :scope "test"]
                  [cljsjs/react "15.5.4-0"]
                  [cljsjs/react-dom "15.5.4-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-transition-group
       :version     +version+
       :description "An easy way to perform animations when a React component enters or leaves the DOM"
       :url         "https://facebook.github.io/react/docs/animation.html"
       :scm         {:url "https://github.com/reactjs/react-transition-group"}
       :license     {"BSD-3-Clause" "https://opensource.org/licenses/BSD-3-Clause"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask build-transition-group []
  (let [tmp (c/tmp-dir!)]
    (with-pre-wrap
      fileset
      ; Copy all files in fileset to temp directory
      (doseq [f (->> fileset c/input-files)
              :let [target  (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (binding [boot.util/*sh-dir* (str tmp)]
        ((sh "npm" "install"))
        ((sh "npm" "run" "build"))
        (io/copy (io/file tmp "lib/dist/react-transition-group.js") (io/file tmp "react-transition-group.js"))
        ((sh "npm" "run" "build" "--" "--" "--output-filename" "react-transition-group-dev.js" "-d" "--define" "process.env.NODE_ENV='development'")))
      (-> fileset (c/add-resource tmp) c/commit!))))

(deftask package []
  (comp
   (download :url (str "https://github.com/reactjs/react-transition-group/archive/v" +lib-version+ ".zip")
             :checksum "6d974454da82f323c06f85c2891fbc4f"
             :unzip true)
   (sift :move {#"^react-transition-group-\d?\.\d?.\d?/" ""})
   (build-transition-group)

   (sift :move {#"^react-transition-group.js$" "cljsjs/react-transition-group/production/react-transition-group.min.inc.js"
                #"^lib[/ \\]dist[/ \\]react-transition-group-dev.js$" "cljsjs/react-transition-group/development/react-transition-group.inc.js"})

   (sift :include #{#"^cljsjs"})

   (deps-cljs :name "cljsjs.react-transition-group"
              :requires ["cljsjs.react"
                         "cljsjs.react.dom"])
   (pom)
   (jar)))
