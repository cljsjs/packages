(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.3.0-jenanwise")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project 'cljsjs/gl-matrix
      :version +version+
      :description "Javascript Matrix and Vector library for High Performance WebGL apps"
      :url "http://glmatrix.net/"
      :scm {:url "https://github.com/toji/gl-matrix"}
      :license {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download
    :url (str "https://raw.githubusercontent.com/jenanwise/gl-matrix/v" +lib-version+ "/dist/gl-matrix.js")
    :checksum "6082aba84ad522cd32b653c815491568")
   (download
    :url (str "https://raw.githubusercontent.com/jenanwise/gl-matrix/v" +lib-version+ "/dist/gl-matrix-min.js")
    :checksum "eb7bc1a30db399a714a957b59cf4da92")
   (sift :move {#"^gl-matrix.js"
                "cljsjs/gl-matrix/development/gl-matrix.inc.js"
                #"^gl-matrix-min.js"
                "cljsjs/gl-matrix/production/gl-matrix.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.gl-matrix")
   (pom)
   (jar)))
