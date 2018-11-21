(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh info]])

(def +lib-version+ "0.3.2")
(def +version+ (str +lib-version+ "-0"))

(def pkg-dir (format "rebass-%s" +lib-version+))

(task-options!
  pom {:project     'cljsjs/rebass
       :version     +version+
       :description "Configurable React Stateless Functional UI Components"
       :url         "http://jxnblk.com/rebass/"
       :scm         {:url "https://github.com/jxnblk/rebass"}})

(deftask build-rebass []
  (let [tmp (tmp-dir!)]
    (with-pre-wrap
      fileset
      (doseq [f (->> fileset input-files)
              :let [target (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (binding [boot.util/*sh-dir* (str (io/file tmp pkg-dir))]
        (do ((sh "npm" "install"))
            ((sh "node_modules/.bin/webpack" "-d" "--config" "src/webpack.config.dev.js"))
            ((sh "node_modules/.bin/webpack" "-p" "--config" "src/webpack.config.prod.js"))))
      (-> fileset (add-resource tmp) commit!))))

(deftask package []
  (comp
    (download :url (str "https://github.com/jxnblk/rebass/archive/v" +lib-version+ ".zip")
              :checksum "ac458c48bf78fac23f9f03c3f3729349"
              :unzip true)

    (build-rebass)

    (sift :move {#"^rebass[^/]*/src/bundle-dev.js"  "cljsjs/rebass/development/rebass.inc.js"
                 #"^rebass[^/]*/src/bundle-dev.map" "cljsjs/rebass/development/rebass.inc.map"
                 #"^rebass[^/]*/src/bundle.js"      "cljsjs/rebass/production/rebass.min.inc.js"})

    (sift :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.rebass"
               :requires ["cljsjs.react"])
    (pom)
    (jar)))

