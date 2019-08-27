(def +lib-version+ "1.2.8")
(def +version+ (str +lib-version+ "-0"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/interact
       :version     +version+
       :description "JavaScript drag and drop, resizing and multi-touch gestures with inertia and snapping for modern browsers (and also IE8+)"
       :url         "https://github.com/taye/interact.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(def modules
  {"interact" "2D7EABA1B03522CF79F05E16D6C12CCF",
   "interact.min" "8E55489EFFB2A8535F618256580281F9"})

(defn get-module-url [module]
  (str "https://unpkg.com/interact.js@" +lib-version+ "/dist/" module ".js"))

(defn download-module [[module checksum]]
  (download :url (get-module-url module) :checksum checksum))

(defn download-modules []
  (reduce #(comp %1 (download-module %2)) identity modules))

(deftask package  []
  (comp
    (download-modules)
    (sift :move {#"^interact\.min\.js$"                "cljsjs/interact/production/interact.min.inc.js"
                 #"^interact\.js$"                     "cljsjs/interact/development/interact.inc.js"})
    (sift :include #{#"^cljsjs" #"^deps.cljs"})
    (pom)
    (jar)))

(defn md5sum [fileset name]
  (with-open [is  (clojure.java.io/input-stream (tmp-file (tmp-get fileset name)))
              dis (java.security.DigestInputStream. is (java.security.MessageDigest/getInstance "MD5"))]
    (#'cljsjs.boot-cljsjs.packaging/realize-input-stream! dis)
    (#'cljsjs.boot-cljsjs.packaging/message-digest->str (.getMessageDigest dis))))

(deftask load-checksums
  "Task to create checksums map for new version"
  []
  (comp
   (reduce #(comp %1 (download :url (get-module-url %2))) identity (keys modules))
    (fn [handler]
      (fn [fileset]
        (clojure.pprint/pprint
         (into {}
               (map (juxt identity #(md5sum fileset (str % ".js")))
                    (keys modules))))
        fileset))))
