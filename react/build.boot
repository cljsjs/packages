(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.9.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "16.2.0")
(def +version+ (str +lib-version+ "-1"))

(def npm-project {'cljsjs/react "react"
                  'cljsjs/react-dom "react-dom"})

(task-options!
 pom  {:project     'cljsjs/react
       :version     +version+
       :description "A Javascript library for building user interfaces"
       :url         "http://facebook.github.io/react/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

;; TODO: Should eventually be included in boot.core
(defn with-files
  "Runs middleware with filtered fileset and merges the result back into complete fileset."
  [p middleware]
  (fn [next-handler]
    (fn [fileset]
      (let [merge-fileset-handler (fn [fileset']
                                    (next-handler (commit! (assoc fileset :tree (merge (:tree fileset) (:tree fileset'))))))
            handler (middleware merge-fileset-handler)
            fileset (assoc fileset :tree (reduce-kv
                                          (fn [tree path x]
                                            (if (p x)
                                              (assoc tree path x)
                                              tree))
                                          (empty (:tree fileset))
                                          (:tree fileset)))]
        (handler fileset)))))

(defn download-react [project part]
  (comp
    (download :url (format "https://unpkg.com/%s@%s/umd/%s.development.js" project +lib-version+ part)
              :target (format "cljsjs/%1$s/development/%2$s.inc.js" project part))
    (download :url (format "https://unpkg.com/%s@%s/umd/%s.production.min.js" project +lib-version+ part)
              :target (format "cljsjs/%1$s/production/%2$s.min.inc.js" project part))))

(deftask package-react []
  (with-files (fn [x] (#{"react.ext.js"} (.getName (tmp-file x))))
    (comp
      (download-react "react" "react")
      (deps-cljs :provides ["react" "cljsjs.react"]
                 :requires []
                 :global-exports '{react React})
      (pom :project 'cljsjs/react
           :dependencies [])
      (show :fileset true)
      (jar))))

;; TODO: Generallize for other packages?
(require '[boot.core :as c]
         '[boot.util :as util]
         '[clojure.java.io :as io]
         '[clojure.pprint :as pprint])

(c/deftask new-deps-cljs
  [f foreign-libs FOREIGN-LIBS edn ""
   e externs EXTERNS edn ""]
  (let [tmp              (c/tmp-dir!)
        deps-file        (io/file tmp "deps.cljs")]
    (c/with-pre-wrap fileset
      (let [in-files (c/input-files fileset)]

        (let [foreign-libs (mapv (fn [{:keys [file file-min] :as lib}]
                                   (let [files (c/by-re [file] in-files)
                                         files-min (c/by-re [file-min] in-files)]
                                     (assert (or (not file) (= (count files) 1)))
                                     (assert (or (not file-min) (= (count files-min) 1)))
                                     (cond-> lib
                                       file (assoc :file (c/tmp-path (first files)))
                                       file-min (assoc :file-min (c/tmp-path (first files-min))))))
                                 foreign-libs)
              externs (vec (mapcat (fn [re]
                                     (c/by-re [re] in-files))
                                   externs))
              data    (merge {:foreign-libs foreign-libs}
                             (if (seq externs)
                               {:externs (mapv c/tmp-path externs)}))
              s (with-out-str (pprint/pprint data))]
          (util/info (str "deps.cljs:\n" s))
          (spit deps-file s)
          (-> fileset
              (c/add-resource tmp)
              c/commit!))))))

(deftask package-dom []
  (with-files (fn [x] (re-find #"react-dom.*\.ext\.js" (.getName (tmp-file x))))
    (comp
      (download-react "react-dom" "react-dom")
      (download-react "react-dom" "react-dom-server.browser")
      (download-react "react-dom" "react-dom-test-utils")
      (new-deps-cljs :foreign-libs [{:file #"react-dom\.inc\.js"
                                 :file-min #"react-dom\.min\.inc\.js"
                                 :provides ["react-dom" "cljsjs.react-dom"]
                                 :requires ["react"]
                                 :global-exports '{react-dom ReactDOM}}
                                {:file #"react-dom-server\.browser\.inc\.js"
                                 :file-min #"react-dom-server\.browser\.min\.inc\.js"
                                 :provides ["react-dom/server" "cljsjs.react.dom.server"]
                                 :requires ["react-dom"]
                                 :global-exports '{react-dom/server ReactDOMServer}}
                                {:file #"react-dom-test-utils\.inc\.js"
                                 :file-min #"react-dom-test-utils\.min\.inc\.js"
                                 :provides ["react-dom/test-utils" "cljsjs.react.dom.test-utils"]
                                 :requires ["react-dom"]
                                 :global-exports '{react-dom/test-utils ReactTestUtils}}]
                 :externs [#"react-dom.*\.ext\.js"])
      (pom :project 'cljsjs/react-dom
           :dependencies [['cljsjs/react +version+]])
      (show :fileset true)
      (jar))))

(deftask package-dom-server-stub []
  (with-files (constantly nil)
    (comp
      (pom :project 'cljsjs/react-dom-server
           :description "React-dom-server package is now deprecated, the server file is included in react-dom package."
           :dependencies [['cljsjs/react-dom +version+]])
      (show :fileset true)
      (jar))))

(deftask package []
  (comp
    (package-react)
    (package-dom)
    (package-dom-server-stub)
    (validate)))
