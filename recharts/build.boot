(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]
                  [cljsjs/react "15.3.1-0"]])

(require '[boot.core :as c]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.13.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/recharts
       :version     +version+
       :description "Redefined chart library built with React and D3"
       :url         "http://recharts.org"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://raw.githubusercontent.com/react-bootstrap/react-bootstrap/master/LICENSE"}})

(deftask build-recharts []
  (let [tmp (c/temp-dir!)]
    (with-pre-wrap
      fileset
      ; Copy all files in fileset to temp directory
      (doseq [f (->> fileset c/input-files)
              :let [target  (io/file tmp (tmpd/path f))]]
        (io/make-parents target)
        (io/copy (tmpd/file f) target))
      (binding [boot.util/*sh-dir* (str tmp)]
        ((sh "npm" "install"))
        ((sh "npm" "run-script" "build")))
      (-> fileset (c/add-resource tmp) c/commit!))))

(deftask package []
  (comp
    (download :url (format "https://github.com/recharts/recharts/archive/v%s.zip" +lib-version+)
              :unzip true
              :checksum "6AF2EA00325BECC27A5E71F2F401BA1A")
    (sift :move {#"^recharts-\d?\.\d*?\.\d?/" ""})
    (build-recharts)
    (sift :move {#"umd/Recharts\.js" "cljsjs/recharts/development/Recharts.inc.js"
                 #"umd/Recharts\.min\.js" "cljsjs/recharts/production/Recharts.min.inc.js"})
    (deps-cljs :name "cljsjs.recharts"
               :requires ["cljsjs.react"])
    (sift :include #{#"^cljsjs" #"^deps\.cljs$"})
    (pom)
    (jar)))
