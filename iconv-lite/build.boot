(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[clojure.java.shell :as shell]
         '[clojure.java.io :as io])

(def +lib-version+ "0.4.18")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project 'cljsjs/iconv-lite
      :version +version+
      :description "Convert character encodings in pure javascript."
      :url "https://github.com/ashtuchkin/iconv-lite"
      :scm {:url "https://github.com/ashtuchkin/iconv-lite"}
      :license {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask buildjs []
  (with-pre-wrap fileset
    (let [tmp (tmp-dir!)
          tmp-dir (.getAbsolutePath tmp)]
      (dosh "cp" "-r" "./buildjs" tmp-dir)
      (binding [*sh-dir* (str tmp-dir "/buildjs")]
        (dosh "npm" "install")
        (dosh "mkdir" "-p" "dist/cljsjs/iconv-lite/development")
        (dosh "mkdir" "-p" "dist/cljsjs/iconv-lite/production")
        (dosh "node" "build.js"))
      (-> fileset
          (add-resource (io/file tmp "buildjs/dist"))
          commit!))))

(deftask package []
  (comp
   (buildjs)
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.iconv-lite")
   (pom)
   (jar)))
