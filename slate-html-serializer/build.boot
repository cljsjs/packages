(def +lib-version+ "0.6.1")
(def +version+ (str +lib-version+ "-0"))

(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.0" :scope "test"]
                 [cljsjs/react            "16.3.0-0"]
                 [cljsjs/react-dom        "16.3.0-0"]
                 [cljsjs/react-dom-server "16.3.0-0"]
                 [cljsjs/slate            "0.33.4-0"]
                 [cljsjs/immutable        "3.8.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/slate-html-serializer
       :version     +version+
       :description "An HTML serializer for Slate documents."
       :url         "http://slatejs.org"
       :scm         {:url "https://github.com/ianstormtaylor/slate"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package  []
  (comp
   (download :url (str "https://unpkg.com/slate-html-serializer@" +lib-version+  "/dist/slate-html-serializer.js")
             :checksum "98502e9a2e6a31b6908572e4b213ea8a")
   (download :url (str "https://unpkg.com/slate-html-serializer@" +lib-version+  "/dist/slate-html-serializer.min.js")
             :checksum "e201771bda3d0b7c0ebcd40f49a10869")
   (sift :move {#"^slate-html-serializer.js$"
                "cljsjs/slate-html-serializer/development/slate-html-serializer.inc.js"
                #"^slate-html-serializer.min.js"
                "cljsjs/slate-html-serializer/production/slate-html-serializer.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.slate-html-serializer"
              :requires ["cljsjs.react" "cljsjs.react.dom" "cljsjs.react.dom.server" "cljsjs.slate" "cljsjs.immutable"])
   (pom)
   (jar)))
