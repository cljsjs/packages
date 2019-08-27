(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]
                 [asset-minifier "0.2.4" :scope "test"]
                 [cljsjs/three "0.0.91-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.0.91")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/three-examples
      :version     +version+
      :description "JavaScript 3D library examples and various utilities."
      :url         "http://threejs.org/"
      :scm         {:url "https://github.com/mrdoob/three.js"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(require '[boot.core :as c]
         '[boot.pod  :as pod]
         '[boot.util :as util]
         '[clojure.java.io :as io]
         'asset-minifier.core)

(deftask generate-deps []
  (let [tmp (c/tmp-dir!)
        new-deps-file (io/file tmp "deps.cljs")
        path->foreign-lib (fn [path]
                            (let [[js-path parent ns] (re-matches #"cljsjs/three-examples/development/(.*/)?(.*)\.inc\.js" path)]
                              {:file     path
                               :file-min (str "cljsjs/three-examples/production/" parent ns ".min.inc.js")
                               :requires ["cljsjs.three"]
                               :provides [(str "cljsjs.three-examples."
                                               (when (some? parent) (clojure.string/replace parent "/" "."))
                                               ns)]}))]
    (with-pre-wrap
      fileset
      (let [existing-deps-file (->> fileset c/input-files (c/by-name ["deps.cljs"]) first)
            existing-deps      (-> existing-deps-file c/tmp-file slurp read-string)
            dev-files          (->> fileset c/input-files (c/by-re [#"^cljsjs/three-examples/development/.*\.inc\.js"]))
            libs               (map (comp path->foreign-lib c/tmp-path) dev-files)
            new-deps           (assoc-in existing-deps [:foreign-libs] libs)]
        (util/info "Generating deps.cljs.\n")
        (spit new-deps-file (pr-str new-deps))
        (-> fileset (c/add-resource tmp) c/commit!)))))



(deftask minify-set
  "Minifies .js and .css files based on their file extension"
  []
  (let [tmp      (c/tmp-dir!)
        in->out-path (fn [path]
                       (when-let [[js-path parent ns] (re-matches #"cljsjs/three-examples/development/(.*/)?(.*)\.inc\.js" path)]
                         (str "cljsjs/three-examples/production/" parent ns ".min.inc.js")))]
    (with-pre-wrap
      fileset
      (let [dev-files (->> fileset c/input-files (c/by-re [#"^cljsjs/three-examples/development/.*\.inc\.js"]))
            out-paths (map (comp in->out-path c/tmp-path) dev-files)]
        (util/info "Minifying javascript.\n")
        (doall (map (fn [in-file out-path]
                      (let [in-path (.getPath (c/tmp-file in-file))
                            out-file (io/file tmp out-path)]
                        (io/make-parents out-file)
                        (when (pos? (count (:errors (asset-minifier.core/minify-js in-path (.getPath out-file) {:quiet? true}))))
                          (util/warn "Could not minify %s, copying original.\n" (.getName (c/tmp-file in-file)))
                          (util/sh "cp" in-path (.getPath out-file)))))
                    dev-files
                    out-paths))
        (-> fileset
            (c/add-resource tmp)
            c/commit!)))))

(deftask generate-externs []
  (let [tmp (c/tmp-dir!)
        externs-file (io/file tmp "cljsjs/three-examples/common/three-examples.ext.js")]
    (with-pre-wrap
      fileset
      (let [threejs-path (->> fileset
                              c/input-files
                              (c/by-re [#"build/three.js"])
                              (map (comp #(.getPath %) c/tmp-file))
                              first)
            package-file (->> fileset
                              c/input-files
                              (c/by-re [#"package.json"])
                              (map c/tmp-file)
                              first)
            input-string (->> fileset
                              c/input-files
                              (c/by-re [#"examples/js/.*\.js"])
                              (map (comp #(.getPath %) c/tmp-file))
                              (cons threejs-path)
                              (clojure.string/join ","))]
        (util/info "Generating externs.\n")
        (io/make-parents externs-file)
        (io/copy package-file (io/file tmp "package.json"))
        (binding [boot.util/*sh-dir* (str tmp)]
          ((sh "npm" "install" "externs-generator"))
          ((sh "node_modules/externs-generator/bin/extern"
               "-f" input-string
               "-n" "THREE"
               "-o" (.getPath externs-file))))
        (-> fileset (c/add-resource tmp) c/commit!)))))

(deftask update-externs []
  (comp
   (download  :url      "https://github.com/mrdoob/three.js/archive/r91.zip"
              :unzip    true
              :checksum "74ffeb0bda51e556aaa2d726c7a3577d")
   (sift      :move     {#"^three\.js-r\d*/" ""})
   (generate-externs)
   (sift      :include  #{#"^cljsjs"})
   (target    :dir      #{"resources"})))

(deftask package []
  (comp
   (download  :url      "https://github.com/mrdoob/three.js/archive/r91.zip"
              :unzip    true
              :checksum "74ffeb0bda51e556aaa2d726c7a3577d")
   (sift      :move     {#"^three\.js-r\d*/"
                         ""
                         #"examples/js/(.*)\.js"
                         "cljsjs/three-examples/development/$1.inc.js"
                         #"examples/js/(.*/)(.*)\.js"
                         "cljsjs/three-examples/development/$1$2.inc.js"})
   (minify-set)
   (deps-cljs :name     "cljsjs.three-examples"
              :requires ["cljsjs.three"])
   (sift      :include  #{#"^cljsjs" #"deps\.cljs"})
   (generate-deps)
   (pom)
   (jar)))
