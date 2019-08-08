(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]
                  [cljsjs/react "15.6.1-1"]
                  [cljsjs/react-dom "15.6.1-1"]
                  [cljsjs/three "0.0.87-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh dosh]]
         '[boot.from.me.raynes.conch :as conch])

(def +lib-version+ "3.2.3")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "react-three-renderer-%s" +lib-version+))

(defn sh2
  "Evaluate args as a shell command, asynchronously, and return a thunk which
  may be called to block on the exit status. Output from the shell is streamed
  to stdout and stderr as it is produced."
  [& args]
  (let [args (remove nil? args)]
    (let [opts (into [:redirect-err true] (when boot.util/*sh-dir* [:dir *sh-dir*]))
          proc (apply conch/proc (concat args opts))]
      (future (conch/stream-to-out proc :out))
      #(.waitFor (:process proc)))))

(task-options!
  pom {:project     'cljsjs/react-three-renderer
       :version     +version+
       :description "Render into a three.js canvas using React"
       :url         "https://toxicfork.github.com/react-three-renderer-example/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(def url (format "https://github.com/toxicFork/react-three-renderer/archive/v%s.zip" +lib-version+))

(deftask download-react-three-renderer []
  (download :url url
            :checksum "df64bb5814c2825cd7bfd0ed51940737"
            :unzip true))

(def webpack-file-name "webpack.config.js")

(defn get-file [fileset file-name]
  (io/file
    (:dir (first (filter #(= (:path %) file-name) (boot/user-files fileset))))
    file-name))

(deftask build-react-three-renderer []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap fileset
      (doseq [f (->> fileset boot/input-files)
              :let [target (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (io/copy (get-file fileset webpack-file-name)
               (io/file tmp +lib-folder+ webpack-file-name))
      (binding [boot.util/*sh-dir* (str (io/file tmp +lib-folder+))]
        (do (dosh "npm" "install")
            (dosh "npm" "install" "webpack")
            (dosh "npm" "run" "compile")
            (dosh "./node_modules/.bin/webpack")
            ((sh2 "./node_modules/.bin/webpack" :env {"NODE_ENV" "production"}))
            (dosh "rm" "-rf" "./node_modules")))
      (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
    (download-react-three-renderer)
    (build-react-three-renderer)
    (sift :move {#".*react-three-renderer.inc.js"
                 "cljsjs/react-three-renderer/development/react-three-renderer.inc.js"
                 #".*react-three-renderer.min.inc.js"
                 "cljsjs/react-three-renderer/production/react-three-renderer.min.inc.js"})
    (sift :include #{#"^cljsjs" #"^deps.cljs"})
    (pom)
    (jar)))
