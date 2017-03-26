(set-env!
 :repositories #(conj % '["bintray" {:url "http://dl.bintray.com/nitram509/jbrotli"}])
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.6.0" :scope "test"]
                 [nha/boot-uglify "0.0.7" :scope "test"]])

(def +version+ "0.1.1-0")
(def +kld-intersections-git-sha+ "8649b0e47b70b16d9ad8a6db61c66de13b134e56")
(def +kld-affine-git-sha+ "0cff191c75e326933edad63c1a6da207a8888a03")
(def +kld-polynomial-git-sha+ "c70584ed1cb434a373c85129a4a39480907e70bf")

(task-options!
 pom  {:project     'cljsjs/kld-intersections
       :version     +version+
       :description "Intersection is a JavaScript object used to capture the results of the intersection of two Shape objects."
       :url         "http://www.quazistax.com/testIntersection.html"
       :scm         {:url "git://github.com/thelonious/kld-intersections.git"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[nha.boot-uglify.minify-js :as minify-js]
         '[boot.core :as c]
         '[boot.util :as u]
         '[boot.file :as file]
         '[clojure.java.io :as io])

(defn normalize-path
  "Adds a / if missing at the end of the path."
  [path]
  (if-not (= \/ (last path))
    (str path "/")
    path))

(c/deftask uglify
  "Create the minified file

  This task also copies the minified file in the development folder."
  [_ working-dir DIR str "Path where the js files to uglify will be in"
   _ file-name NAME [str] "Vector of JS source file names to uglify (order counts)"
   _ prod-dir DIR str "The package production dir"
   _ dev-dir DIR str "The package development dir"
   _ prod-name NAME str "File name for the minified file"
   _ dev-name NAME str "File name for the development file"]
  (let [tmp (c/tmp-dir!)]
    (c/with-pre-wrap fileset
      (let [real-dir (->> (c/ls fileset)
                          (c/by-re [(re-pattern working-dir)])
                          first
                          c/tmp-file
                          .getParent
                          normalize-path)
            prod-file (io/file tmp (str prod-dir prod-name))
            dev-file (io/file tmp (str dev-dir dev-name))]
        (u/dbug* "Minifying content of: %s\n" real-dir)
        (let [uglify-result (minify-js/minify-js (mapv #(str real-dir %) file-name)
                                                 prod-file)]
          (u/dbug* "Uglify result: %s\n" (u/pp-str uglify-result)))
        (u/dbug* "Minified file: %s\n" prod-file)
        (u/dbug* "Development file: %s\n" dev-file)
        (io/make-parents dev-file)
        (file/copy-atomically prod-file dev-file)
        (-> fileset (c/add-resource tmp) c/commit!)))))

(deftask package []
  (let [uglify-dir (normalize-path "uglify/")
        prod-dir (normalize-path "cljsjs/kld-intersections/production/")
        dev-dir (normalize-path "cljsjs/kld-intersections/development/")]
    (comp
     (download :url (format "https://github.com/thelonious/kld-intersections/archive/%s.zip" +kld-intersections-git-sha+)
               :checksum "4FC9F3EB7AFFF07AAB7FB83F21AB51C2"
               :unzip true)
     (sift :move {#"^kld-intersections-.*/lib/Intersection.js" (str uglify-dir "Intersection.js")})
     (sift :move {#"^kld-intersections-.*/lib/IntersectionParams.js" (str uglify-dir "IntersectionParams.js")})

     ;; dep kld-affine
     (download :url (format "https://github.com/thelonious/kld-affine/archive/%s.zip" +kld-affine-git-sha+)
               :checksum "128D365DC895A8030E1750B186A5C2B6"
               :unzip true)
     (sift :move {#"^kld-affine-.*/lib/Matrix2D.js" (str uglify-dir "Matrix2D.js")})
     (sift :move {#"^kld-affine-.*/lib/Vector2D.js" (str uglify-dir "Vector2D.js")})
     (sift :move {#"^kld-affine-.*/lib/Point2D.js" (str uglify-dir "Point2D.js")})

     ;; dep kld-polynomial
     (download :url (format "https://github.com/thelonious/kld-polynomial/archive/%s.zip" +kld-polynomial-git-sha+)
               :checksum "7FFDE4750098CD589E55F198EA64EDFE"
               :unzip true)
     (sift :move {#"^kld-polynomial-.*/lib/Polynomial.js" (str uglify-dir "Polynomial.js")})
     (sift :move {#"^kld-polynomial-.*/lib/PolynomialAdditionalMethods.js" (str uglify-dir "PolynomialAdditionalMethods.js")})
     (sift :move {#"^kld-polynomial-.*/lib/SqrtPolynomial.js" (str uglify-dir "SqrtPolynomial.js")})

     (uglify :file-name ["Point2D.js"
                         "Vector2D.js"
                         "Matrix2D.js"
                         "Polynomial.js"
                         "SqrtPolynomial.js"
                         "PolynomialAdditionalMethods.js"
                         "IntersectionParams.js"
                         "Intersection.js"]
             :prod-name "kld-intersections.min.inc.js"
             :dev-name "kld-intersections.inc.js"
             :working-dir uglify-dir
             :prod-dir prod-dir
             :dev-dir dev-dir)

     (sift :include  #{#"^cljsjs"})

     (deps-cljs :name "cljsjs.kld-intersections")
     (pom)
     (jar))))
