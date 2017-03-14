(def +lib-version+ "1.4.0")
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
  {"inferno" "C2C68465392D881AC7DB67C5A0D7FA87",
   "inferno-hyperscript.min" "2BEA21DC67F757878691022611751DB6",
   "inferno.min" "981F6FEE84BE9F1871AE05652CB159B4",
   "inferno-create-element" "BC30F0C0122174802637FD44BB08F6F3",
   "inferno-hyperscript" "E3CA6E01A36FC721102BB3B251095183",
   "inferno-component" "389D120DFCBD30CA21F97911471E5DEA",
   "inferno-create-element.min" "148C35C3E8D16079058BE80522F2DE5C",
   "inferno-component.min" "3A1262EDDA690688B7FCDE4E4697162C",
   "inferno-create-class.min" "AEDD207F06226B29B92443C0B3B2242C",
   "inferno-create-class" "CC2A1687AA339BD39CC62244101544E6"})

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
