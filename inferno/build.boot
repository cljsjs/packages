(def +lib-version+ "1.5.3")
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
  {"inferno" "D16E79F1F9B191A89FAF60C908E49E88",
   "inferno-hyperscript.min" "C9694DB078CB5AC4AB021E08982E1D9A",
   "inferno.min" "33E370660BA02FD01D35AF222E008B0D",
   "inferno-create-element" "3CEFD8632C501AE2A3670D7B92E3D217",
   "inferno-hyperscript" "88F06ECE7D71560CFC558038DF7B9C72",
   "inferno-component" "079E6269C32A15BBC621812A2FE8878B",
   "inferno-create-element.min" "DAF1EAA27D642C8D0C7950C9BB49C588",
   "inferno-component.min" "5EF5BDA974294733980B1321F3E4047C",
   "inferno-create-class.min" "FCC7CF7E97325FFEA1C9CEF3E956E83F",
   "inferno-create-class" "C1EE63BFA62DD99B253ECB7771091B72"})

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
