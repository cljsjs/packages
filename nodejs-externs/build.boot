(set-env!
 :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[boot.core :as core]
         '[boot.tmpdir :as tmpd]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.4")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom {:project     'cljsjs/nodejs-externs
      :version     +version+
      :description "Node.js Google Closure Compiler Externs"
      :url         "https://github.com/dcodeIO/node.js-closure-compiler-externs"
      :scm         {:url "https://github.com/cljsjs/packages"}
      :license     {"Apache License" "http://www.apache.org/licenses/LICENSE-2.0.html"}})

(deftask download-nodejs-externs []
  (download :url (format "https://github.com/dcodeIO/node.js-closure-compiler-externs/archive/%s.zip" +lib-version+)
            :checksum "857bf4b4600c87a553293e7cc2dc7cea"
            :unzip true))

(deftask generate-local-deps []
  (let [tmp (core/tmp-dir!)
        deps-file (clojure.java.io/file tmp "deps.cljs")]
    (with-pre-wrap fileset
      (let [extern-files (->> fileset core/input-files (core/by-re [#"cljsjs/nodejs-externs/common/.*.js"]))
            deps-edn {:externs (mapv tmpd/path extern-files)}]
        (spit deps-file (pr-str deps-edn))
        (-> fileset (core/add-resource tmp) core/commit!)))))

(deftask package []
  (comp
   (download-nodejs-externs)
   (sift :move {#"^node.js-closure-compiler-externs-[^/]*/([^/]*).js$"
                "cljsjs/nodejs-externs/common/$1.js"})
   (sift :include #{#"^cljsjs"})
   (generate-local-deps)
   (pom)
   (jar)))
