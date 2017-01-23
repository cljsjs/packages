(def +lib-version+ "1.2.1")
(def +version+ (str +lib-version+ "-0"))

(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/inferno
       :version     +version+
       :description "Inferno is an insanely fast, 7kb React-like library for building high-performance user interfaces on both the client and server."
       :url         "https://github.com/trueadm/inferno"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(defn download-inferno []
  (download :url (str "https://unpkg.com/inferno@" +lib-version+ "/dist/inferno.js")
            :checksum "a584b6e19369e13845ad49ee4153ea9a"))

(defn download-inferno-min []
  (download :url (str "https://unpkg.com/inferno@" +lib-version+ "/dist/inferno.min.js")
            :checksum "e483e2f41e51f1067b9762eb9fbd9882"))


(defn download-inferno-component []
  (download :url (str "https://unpkg.com/inferno@" +lib-version+ "/dist/inferno-component.js")
            :checksum "cb9bd707201297d8ef8b6d5462c7cd1e"))

(defn download-inferno-component-min []
  (download :url (str "https://unpkg.com/inferno@" +lib-version+ "/dist/inferno-component.min.js")
            :checksum "3ffcba2ecd9b0ccf26d01217acb214c5"))


(defn download-inferno-create-element []
  (download :url (str "https://unpkg.com/inferno@" +lib-version+ "/dist/inferno-create-element.js")
            :checksum "0f5511413c7806ce47f07a1a49b268d2"))

(defn download-inferno-create-element-min []
  (download :url (str "https://unpkg.com/inferno@" +lib-version+ "/dist/inferno-create-element.min.js")
            :checksum "8498b6f8754e247c5c56adbc156de6bc"))

(defn download-inferno-create-class []
  (download :url (str "https://unpkg.com/inferno@" +lib-version+ "/dist/inferno-create-class.js")
            :checksum "c6c3275d562cfdd6f89248780cb5628e"))

(defn download-inferno-create-class-min []
  (download :url (str "https://unpkg.com/inferno@" +lib-version+ "/dist/inferno-create-class.min.js")
            :checksum "1086e16638d2507bc2049efa4c725b77"))

(deftask package  []
  (comp
    (download-inferno)
    (download-inferno-min)
    (download-inferno-component)
    (download-inferno-component-min)
    (download-inferno-create-element)
    (download-inferno-create-element-min)
    (download-inferno-create-class)
    (download-inferno-create-class-min)
    (sift :move {#"^inferno\.min\.js$"                "cljsjs/inferno/production/inferno.min.inc.js"
                 #"^inferno\.js$"                     "cljsjs/inferno/development/inferno.inc.js"
                 #"^inferno-component\.min\.js$"      "cljsjs/inferno/production/inferno-component.min.inc.js"
                 #"^inferno-component\.js$"           "cljsjs/inferno/development/inferno-component.inc.js"
                 #"^inferno-create-element\.min\.js$" "cljsjs/inferno/production/inferno-create-element.min.inc.js"
                 #"^inferno-create-element\.js$"      "cljsjs/inferno/development/inferno-create-element.inc.js"
                 #"^inferno-create-class\.min\.js$"   "cljsjs/inferno/production/inferno-create-class.min.inc.js"
                 #"^inferno-create-class\.js$"        "cljsjs/inferno/development/inferno-create-class.inc.js"})
    (sift :include #{#"^cljsjs" #"^deps.cljs"})
    (pom)
    (jar)))
