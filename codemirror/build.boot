(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.44.0")

(def +version+ (str +lib-version+ "-1"))

(task-options!
  pom  {:project     'cljsjs/codemirror
        :version     +version+
        :scm         {:url "https://github.com/cljsjs/packages"}
        :description "CodeMirror is a versatile text editor implemented in JavaScript for the browser"
        :url         "https://codemirror.net/"
        :license     {"MIT" "https://github.com/codemirror/CodeMirror/blob/master/LICENSE"}})

(require '[boot.core :as c]
         '[clojure.java.io :as io]
         '[clojure.string :as string])

(defn path->foreign-lib [path]
  (let [node-name (-> path
                      (string/replace #"\.inc\.js$" "")
                      (string/replace #"/common/" "/")
                      (string/replace #"^cljsjs/" ""))
        ns (-> path
               (string/replace #"\.inc\.js$" "")
               (string/replace #"/common/" "/")
               (string/replace #"/" "."))]
    {:file     path
     :requires ["codemirror"]
     :provides [node-name ns]}))

(deftask generate-extra-deps []
  (let [tmp (c/tmp-dir!)
        new-deps-file (io/file tmp "deps.cljs")]
    (with-pre-wrap
      fileset
      (let [existing-deps-file (->> fileset c/input-files (c/by-name ["deps.cljs"]) first)
            existing-deps      (-> existing-deps-file c/tmp-file slurp read-string)
            extra-files        (->> fileset c/input-files (c/by-re [ #"cljsjs/codemirror/common/(mode|addon|keymap)/.*\.inc\.js"]))
            foreign-libs       (map (comp path->foreign-lib c/tmp-path) extra-files)
            new-deps           (update-in existing-deps [:foreign-libs] concat foreign-libs)]
        (spit new-deps-file (pr-str new-deps))
        (-> fileset (c/add-resource tmp) c/commit!)))))

(deftask package []
  (comp
    (download :url (format "http://codemirror.net/codemirror-%s.zip" +lib-version+)
              :unzip true)
    (sift :move {#"^codemirror-([\d\.]*)/lib/codemirror\.js"    "cljsjs/codemirror/development/codemirror.inc.js"
                 #"^codemirror-([\d\.]*)/lib/codemirror\.css"   "cljsjs/codemirror/development/codemirror.css"
                 #"^codemirror-([\d\.]*)/mode/meta\.js"         "cljsjs/codemirror/common/mode/meta.js"
                 #"^codemirror-([\d\.]*)/mode/(.*)/\2\.js"      "cljsjs/codemirror/common/mode/$2.js"
                 #"^codemirror-([\d\.]*)/keymap/(.*)\.js"       "cljsjs/codemirror/common/keymap/$2.js"
                 #"^codemirror-([\d\.]*)/addon/(.*)/(.*)\.css"  "cljsjs/codemirror/common/addon/$2/$3.css"
                 #"^codemirror-([\d\.]*)/addon/(.*)/(.*)\.js"   "cljsjs/codemirror/common/addon/$2/$3.js"
                 #"^codemirror-([\d\.]*)/theme/(.*)\.css"       "cljsjs/codemirror/common/theme/$2.css"})
    (minify    :in       "cljsjs/codemirror/development/codemirror.inc.js"
               :out      "cljsjs/codemirror/production/codemirror.min.inc.js")
    (minify    :in       "cljsjs/codemirror/development/codemirror.css"
               :out      "cljsjs/codemirror/production/codemirror.min.css")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :provides ["cljsjs.codemirror" "codemirror"]
               :global-exports '{codemirror CodeMirror})
    (sift :move {#"^cljsjs/codemirror/common/mode/(.*)\.js" "cljsjs/codemirror/common/mode/$1.inc.js"
                 #"^cljsjs/codemirror/common/keymap/(.*)\.js" "cljsjs/codemirror/common/keymap/$1.inc.js"
                 #"^cljsjs/codemirror/common/addon/(.*)/(.*)\.js" "cljsjs/codemirror/common/addon/$1/$2.inc.js"})
    (generate-extra-deps)
    (pom)
    (jar)
    (validate)))
