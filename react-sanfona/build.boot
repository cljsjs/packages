(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3"  :scope "test"]
                 [cljsjs/react       "16.3.2-0"]
                 [cljsjs/react-dom   "16.3.2-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpdir]
         '[boot.util :refer [dosh]]
         '[clojure.java.io :as io])

(def +lib-version+ "1.2.2")
(def +lib-folder+ (format "react-sanfona-%s" +lib-version+))
(def +version+ (str +lib-version+ "-0"))
(defn- dosh-cmd [& args]
  (apply dosh (if (re-find #"^Windows" (.get (System/getProperties) "os.name"))
                (into ["cmd.exe" "/c"] args)
                args)))
(task-options!
 pom  {:project     'cljsjs/react-sanfona
       :version     +version+
       :description "Accessible react accordion component"
       :url         "https://github.com/daviferreira/react-sanfona"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask download-react-sanfona []
  (download :url      (str "https://github.com/daviferreira/react-sanfona/archive/v" +lib-version+ ".zip")
            :unzip    true))

(deftask build []
  (let [tmp (boot/tmp-dir!)]
    (with-pre-wrap fileset
      (doseq [f (boot/input-files fileset)
              :let [target (io/file tmp (tmpdir/path f))]]
        (io/make-parents target)
        (io/copy (tmpdir/file f) target))
      (binding [boot.util/*sh-dir* (str (io/file tmp +lib-folder+))]
        (dosh-cmd "npm" "install")
        (dosh-cmd "npm" "run" "bundle-dist"))
      (-> fileset
          (boot/add-resource tmp)
          boot/commit!))))

(deftask package []
  (comp
   (download-react-sanfona)
   (build)
   (minify :in (str "react-sanfona-" +lib-version+ "/dist/react-sanfona.js")
           :out (str "react-sanfona-" +lib-version+ "/dist/react-sanfona.min.js"))
   (sift :move {#"^react-.*/dist/react-sanfona.js"
                "cljsjs/react-sanfona/development/react-sanfona.inc.js"
                #"^react-.*/dist/react-sanfona.min.js"
                "cljsjs/react-sanfona/production/react-sanfona.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.react-sanfona"
              :requires ["cljsjs.react"
                         "cljsjs.react.dom"])
   (pom)
   (jar)
   (validate)))
