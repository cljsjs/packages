(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def +lib-version+ "0.4.1")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "solidity-sha3-%s" +lib-version+))

(task-options!
 pom  {:project     'cljsjs/solidity-sha3
       :version     +version+
       :description "Solidity sha3 in Javascript"
       :url         "https://github.com/raineorshine/solidity-sha3"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(deftask download-solidity-sha3 []
  (download :url (str "https://github.com/raineorshine/solidity-sha3/archive/v" +lib-version+ ".zip")
            :checksum "c39b0a8b88534a74391f6125e593da07"
            :unzip true))

(def webpack-file-name "webpack.config.js")
(def main-file-name "main.js")

(deftask build []
         (let [tmp (boot/tmp-dir!)]
              (with-pre-wrap
                fileset
                (doseq [f (boot/input-files fileset)]
                       (let [target (io/file tmp (tmpd/path f))]
                            (io/make-parents target)
                            (io/copy (tmpd/file f) target)))
                (io/copy
                  (io/file tmp main-file-name)
                  (io/file tmp +lib-folder+ main-file-name))
                (io/copy
                  (io/file tmp "webpack.config.js")
                  (io/file tmp +lib-folder+ "webpack-cljsjs.config.js"))
                (binding [*sh-dir* (str (io/file tmp +lib-folder+))]
                         ((sh "npm" "install" "--ignore-scripts"))
                         ((sh "npm" "run" "build"))
                         ((sh "npm" "install" "webpack"))
                         ((sh "./node_modules/.bin/webpack" "--config" "webpack-cljsjs.config.js")))
                (-> fileset (boot/add-resource tmp) boot/commit!))))

(deftask package []
  (comp
    (download-solidity-sha3)
    (build)
    (sift :move {#".*solidity-sha3.inc.js" "cljsjs/solidity-sha3/development/solidity-sha3.inc.js"})

    (minify :in  "cljsjs/solidity-sha3/development/solidity-sha3.inc.js"
            :out "cljsjs/solidity-sha3/production/solidity-sha3.min.inc.js")

    (sift :include #{#"^cljsjs"})

    (deps-cljs :name "cljsjs.solidity-sha3"
               :requires ["cljsjs.web3"])
    (pom)
    (jar)))
