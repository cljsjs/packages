(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.4")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 push {:ensure-clean false}
 pom  {:project     'cljsjs/field-kit
       :version     +version+
       :description "FieldKit lets you take control of your text fields."
       :url         "https://github.com/square/field-kit"
       :license     {"Apache" "https://raw.githubusercontent.com/square/field-kit/master/LICENSE"}
       :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp

   (download :url (str "https://github.com/square/field-kit/releases/download/v" +lib-version+ "/field-kit.js")
             :checksum "10763fa39e1bdf334698a53bb8fb10f2"
             :unzip false)

   (download :url (str "https://github.com/square/field-kit/releases/download/v" +lib-version+ "/field-kit.min.js")
             :checksum "b776094c950c17e9a6a21edbf8d638f1"
             :unzip false)

   (sift :move {#"^field-kit.js$" "cljsjs/field-kit/development/field-kit.inc.js"
                #"^field-kit.min.js$" "cljsjs/field-kit/production/field-kit.min.inc.js"})

   (sift :include #{#"cljsjs"})

   (deps-cljs :name "cljsjs.field-kit")

   (pom)

   (jar)))
