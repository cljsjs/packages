(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.0.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/snabbdom
       :version     +version+
       :url         "https://github.com/snabbdom/snabbdom"
       :scm         {:url "https://github.com/cljsjs/packages"}})

(require '[clojure.java.io :as io]
         '[clojure.string :as str])

(defn fiddle []
  (fn [handler]
    (fn [file-set]
      (let [{:keys [dir path]} (get-in file-set [:tree "snabbdom.cjs.js"])
            filename (str (.getPath dir) "/" path)]
        (spit filename (-> (io/file filename)
                           slurp
                           (str/replace "Object.defineProperty(exports, '__esModule', { value: true });"
                                        "var snabbdom = {};")
                           (str/replace "exports" "snabbdom")))
        (handler file-set)))))

(deftask package []
  (comp
   (download :url (str "https://unpkg.com/snabbdom@" +lib-version+ "/build/snabbdom.cjs.js"))
   (fiddle)
   (sift :move {#"snabbdom.cjs.js" "cljsjs/snabbdom/development/snabbdom.inc.js"})
   (sift :include #{#"^cljsjs" #"^deps.cljs"})
   (minify :in "cljsjs/snabbdom/development/snabbdom.inc.js"
           :out "cljsjs/snabbdom/production/snabbdom.min.inc.js")
   (pom)
   (jar)
   (validate)))
