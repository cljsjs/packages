(set-env!
  :source-paths    #{"hoplon"}
  :dependencies '[[org.clojure/clojure       "1.6.0"       :scope "provided"]
                  [boot/core                 "2.0.0-pre27" :scope "provided"]
                  [tailrecursion/boot-useful "0.1.3"       :scope "test"]])

(require ;'[tailrecursion.boot-useful :refer :all]
 '[boot.core       :as  c]
 '[clojure.java.io :as io])

(def +version+ "0.11.2")

;; (useful! +version+)

(task-options!
  pom  [:project     'cljsjs/react
        :version     +version+
        :description "React.js packaged up with Google Closure externs"
        :url         "https://github.com/cljsjs/reactjs"
        :scm         {:url "https://github.com/cljsjs/react"}
        :license     {:name "Eclipse Public License"
                      :url  "http://www.eclipse.org/legal/epl-v10.html"}])

(defn- copy
  [in-file out-file]
  (doto out-file
    io/make-parents
    (spit (slurp in-file))))

(defn- rename [f ext]
  (let [segs (vec (drop-last (clojure.string/split f #"\.")))
        append-ext #(clojure.string/join "." (conj segs %))]
    (case ext
      :inc (append-ext "inc.js")
      :ext (append-ext "ext.js")
      :lib (append-ext "lib.js"))))

(defn- input-file [name fs]
  (try
    (c/tmpfile
     (first
      (c/by-name [name] (c/input-files fs))))
    (catch Exception e
      (println (str "File " name " was not found in input files")))))

(defn- copy-file [classifier name type fs tmp-dir]
  (let [file   (input-file name fs)
        target (str classifier "/" (rename (.getName file) type))]
    (println (str "Copying " (.getName file) " to " target))
    (doto (io/file tmp-dir target)
      io/make-parents
      (spit (slurp file)))))

(c/deftask cljsjs
  "Create a jar with the given classifier"
  [c classifier  str  "Classifier used for generated artifact"
   i inc-js INC [str] "Files that should be included with the .inc.js extension"
   e ext-js EXT [str] "Files that should be included with the .ext.js extension"
   l lib-js LIB [str] "Files that should be included with the .lib.js extension"]
  (let [tmp (c/temp-dir!)
        c   (or classifier "none")]
    (fn middleware [next-handler]
      (fn handler [fileset]
        (doseq [include inc-js]
          (copy-file c include :inc fileset tmp))
        (doseq [extern ext-js]
          (copy-file c extern :ext fileset tmp))
        (doseq [library lib-js]
          (copy-file c library :lib fileset tmp))
        (-> fileset
            (c/add-resource tmp)
            c/commit!
            next-handler)))))

(c/deftask package
  "Package React in various variations" []
  (comp
   (cljsjs :inc-js ["react-0.11.2.js"]
           :ext-js ["react-externs.js"])
   (cljsjs :classifier "min"
           :inc-js ["react-0.11.2.js"]
           :ext-js ["react-externs.js"])
   (cljsjs :classifier "addons"
           :inc-js ["react-with-addons-0.11.2.js"]
           :ext-js ["react-externs.js"])
   (cljsjs :classifier "addons-min"
           :inc-js ["react-with-addons-0.11.2.min.js"]
           :ext-js ["react-externs.js"])))
