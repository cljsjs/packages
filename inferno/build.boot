(def +lib-version+ "5.6.0")
(def +version+ (str +lib-version+ "-0"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/inferno
       :version     +version+
       :description "Inferno is an insanely fast, 9kb React-like library for building high-performance user interfaces on both the client and server."
       :url         "https://github.com/infernojs/inferno"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(def modules
  {"inferno" "67D599FB72C96C38B4C03B815F593D53",
   "inferno.min" "F598B0E9C93D496EE55ACDB6776DA60B",
   "inferno-hyperscript" "06986B10D261203E95A288EC40762C7D",
   "inferno-hyperscript.min" "91FDC6BF5FD9603300DC41569BEEB12B",
   "inferno-create-element" "0EBDD8CF9BAFFF8F521A8850BB68E14F",
   "inferno-create-element.min" "F08C7A20E8E3A1EEB20A2028E61BE553",
   "inferno-create-class" "1DEDFA18612B9BB689E90CFB7F4E92A9",
   "inferno-create-class.min" "5D78D700B34984B24AC4D5DEC07D53B7"})

(defn get-module-url [module]
  (str "https://unpkg.com/"
       (-> module (clojure.string/split #"\.") first)
       "@" +lib-version+ "/dist/" module ".js"))

(defn download-module [[module checksum]]
  (download :url (get-module-url module) :checksum checksum))

(defn download-modules []
  (reduce #(comp %1 (download-module %2)) identity modules))

(deftask package  []
  (comp
    (download-modules)
    (sift :move {#"^inferno\.min\.js$"                "cljsjs/inferno/production/inferno.min.inc.js"
                 #"^inferno\.js$"                     "cljsjs/inferno/development/inferno.inc.js"
                 #"^inferno-create-element\.min\.js$" "cljsjs/inferno/production/inferno-create-element.min.inc.js"
                 #"^inferno-create-element\.js$"      "cljsjs/inferno/development/inferno-create-element.inc.js"
                 #"^inferno-create-class\.min\.js$"   "cljsjs/inferno/production/inferno-create-class.min.inc.js"
                 #"^inferno-create-class\.js$"        "cljsjs/inferno/development/inferno-create-class.inc.js"
                 #"^inferno-hyperscript\.min\.js$"    "cljsjs/inferno/production/inferno-hyperscript.min.inc.js"
                 #"^inferno-hyperscript\.js$"         "cljsjs/inferno/development/inferno-hyperscript.inc.js"})
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
