(def +lib-version+ "0.4.11")
(def +version+ (str +lib-version+ "-2"))

(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.8.2" :scope "test"]
                 [cljsjs/react            "15.6.2-2"]
                 [cljsjs/react-dom        "15.6.2-2"]
                 [cljsjs/react-dom-server "15.6.2-2"]
                 [cljsjs/slate            "0.31.3-0"]
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
             :checksum "2eb073a3a19a4ae06f7652215e9e1958")
   (download :url (str "https://unpkg.com/slate-html-serializer@" +lib-version+  "/dist/slate-html-serializer.min.js")
             :checksum "04d31f493951da65bbd34e08b968e6d0")
   (sift :move {#"^slate-html-serializer.js$"
                "cljsjs/slate-html-serializer/development/slate-html-serializer.inc.js"
                #"^slate-html-serializer.min.js"
                "cljsjs/slate-html-serializer/production/slate-html-serializer.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.slate-html-serializer"
              :requires ["cljsjs.react" "cljsjs.react.dom" "cljsjs.react.dom.server" "cljsjs.slate" "cljsjs.immutable"])
   (pom)
   (jar)))
