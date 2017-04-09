(def +lib-version+ "1.6.2")
(def +version+ (str +lib-version+ "-0"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/inferno
       :version     +version+
       :description "Inferno is an insanely fast, 9kb React-like library for building high-performance user interfaces on both the client and server."
       :url         "https://github.com/infernojs/inferno"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(def modules
  {"inferno" "C6BF944224CBC32D835C2E0EA76E81B6",
   "inferno-hyperscript.min" "C9694DB078CB5AC4AB021E08982E1D9A",
   "inferno.min" "3A7DD1CD7C0A1547A402D0875A5104FD",
   "inferno-create-element" "9566EE8BD2B7029465EEC180332A453A",
   "inferno-hyperscript" "DFF58879BE2C422A43174E5274BA87A3",
   "inferno-component" "56E234FD21369C56782C4EF53D365A7D",
   "inferno-create-element.min" "9A3C118A3DD3E7C03EDC1658A8890AEB",
   "inferno-component.min" "6884422F9A73CB28B4CF2F5CC323E8FD",
   "inferno-create-class.min" "A14B9FFD8AB581A4654D92DE3E3E64AF",
   "inferno-create-class" "526280EAD00DB454E6557CF8C8D4AFAE"})

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
                 #"^inferno-component\.min\.js$"      "cljsjs/inferno/production/inferno-component.min.inc.js"
                 #"^inferno-component\.js$"           "cljsjs/inferno/development/inferno-component.inc.js"
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
