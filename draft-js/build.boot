(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.10.0")
(def +version+ (str +lib-version+ "-0"))

(def npm-project "draft-js")

(task-options!
  pom  {:project     'cljsjs/draft-js
        :version     +version+
        :description "A React framework for building text editors"
        :url         "https://facebook.github.io/draft-js/"
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

(deftask package []
  (let [extern-name "draft.ext.js"
        namespace "cljsjs.draft-js"
        project 'cljsjs/draft-js]
    (with-files (fn [x] (= extern-name (.getName (tmp-file x))))
      (comp
        (download
          :url (format "https://unpkg.com/%s@%s/dist/%s.js" npm-project +lib-version+ "Draft")
          :checksum "128669B3562E4650A1CE1DF62C6C3196")
        (download
          :url (format "https://unpkg.com/%s@%s/dist/%s.min.js" npm-project +lib-version+ "Draft")
          :checksum "5EA2FFE83123B9AD37DC12E379142170")
        (sift
          :move {(re-pattern (format "^%s.js$" "Draft")) (format "cljsjs/%1$s/development/%1$s.inc.js" (name project))
                 (re-pattern (format "^%s.min.js$" "Draft")) (format "cljsjs/%1$s/production/%1$s.min.inc.js" (name project))})
        (sift
          :include #{#"^cljsjs"})
        (deps-cljs
          :name namespace :requires ["cljsjs.immutable"] #_["cljsjs.react" "cljsjs.react-dom" "cljsjs.immutable"])
        (pom
          :project project :dependencies [['cljsjs/immutable "3.8.1-0"]])
        (show
          :fileset true)
        (jar)))))


(defn md5sum [fileset name]
  (with-open [is  (clojure.java.io/input-stream (tmp-file (tmp-get fileset name)))
              dis (java.security.DigestInputStream. is (java.security.MessageDigest/getInstance "MD5"))]
    (#'cljsjs.boot-cljsjs.packaging/realize-input-stream! dis)
    (#'cljsjs.boot-cljsjs.packaging/message-digest->str (.getMessageDigest dis))))

(deftask load-checksum
  "Task to create checksums map for new version"
  []
  (comp
    (download :url (format "https://unpkg.com/%s@%s/dist/%s.js" npm-project +lib-version+ "Draft"))
    (download :url (format "https://unpkg.com/%s@%s/dist/%s.min.js" npm-project +lib-version+ "Draft"))
    (fn [handler]
      (fn [fileset]
        (println
          (with-out-str
            (clojure.pprint/pprint
              {:dev (md5sum fileset (format "%s.js" "Draft"))
               :min (md5sum fileset (format "%s.min.js" "Draft"))})))
        fileset))))
