  (def +lib-version+ "0.6.3")
(def +version+ (str +lib-version+ "-0"))

(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs      "0.10.5" :scope "test"]
                 [cljsjs/react            "16.3.2-0"]
                 [cljsjs/react-dom        "16.3.2-0"]
                 [cljsjs/react-dom-server "16.3.2-0"]
                 [cljsjs/slate            "0.33.6-0"]
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
   (download :url (format "https://unpkg.com/slate-html-serializer@%s/dist/slate-html-serializer.js" +lib-version+)
             :target "cljsjs/slate-html-serializer/development/slate-html-serializer.inc.js")
   (download :url (format "https://unpkg.com/slate-html-serializer@%s/dist/slate-html-serializer.min.js" +lib-version+)
             :target "cljsjs/slate-html-serializer/production/slate-html-serializer.min.inc.js")
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.slate-html-serializer"
              :requires ["cljsjs.react" "cljsjs.react.dom" "cljsjs.react.dom.server" "cljsjs.slate" "cljsjs.immutable"])
   (pom)
   (jar)
   (validate)))
