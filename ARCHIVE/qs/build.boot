(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[clojure.java.io :as io])

(def +lib-version+ "6.5.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/qs
       :version     +version+
       :description "A querystring parser with nesting support "
       :url         "https://github.com/ljharb/qs"
       :scm         {:url "https://github.com/ljharb/qs"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask buildjs []
  (with-pre-wrap fileset
    (let [tmp (tmp-dir!)
          tmp-dir (.getAbsolutePath tmp)]
      (dosh "cp" "-r" "./buildjs" tmp-dir)
      (binding [*sh-dir* (str tmp-dir "/buildjs")]
        (dosh "npm" "install")
        (dosh "mkdir" "-p" "dist/cljsjs/qs/development")
        (dosh "mkdir" "-p" "dist/cljsjs/qs/production")
        (dosh "node" "build.js"))
      (-> fileset
          (add-resource (io/file tmp "buildjs/dist"))
          commit!))))

(deftask package []
  (comp
    (buildjs)
    (minify :in "cljsjs/qs/development/qs.inc.js"
            :out "cljsjs/qs/production/qs.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.qs")
    (pom)
    (jar)))
