(def +lib-version+ "1.2.2")
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
  {"inferno" "268efc1f01aa64ddaf9cb7a6b14ca077"
   "inferno.min" "0289d2f7280c95e181870a604669a2f5"
   "inferno-component" "0ab0fa08c6fb2906270ffa3b255a4101"
   "inferno-component.min" "d0397e5e61c841a0205df8ba28d75194"
   "inferno-create-element" "8f259567b6e15aac06f88ec4ced2bdf5"
   "inferno-create-element.min" "ec50b62e28fdfa1a7f393e41944fd18d"
   "inferno-create-class" "7c62dbb5dc5ae54679c319d647a2935f"
   "inferno-create-class.min" "1086e16638d2507bc2049efa4c725b77"
   "inferno-hyperscript" "58b79bfc87d9597b90f189d1a97ae2bd"
   "inferno-hyperscript.min" "0597fcba1208547d11d4e0f4f9220517"})

(defn download-module [[module checksum]]
  (download :url (str "https://unpkg.com/inferno@" +lib-version+ "/dist/" module ".js")
            :checksum checksum))

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
