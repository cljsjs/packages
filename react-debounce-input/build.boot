(def +lib-version+ "3.0.0")
(def +version+ (str +lib-version+ "-0"))

(set-env!
 :resource-paths #{"resources"}
 :dependencies   [['cljsjs/boot-cljsjs "0.10.3" :scope "test"]
                  ['cljsjs/react "15.5.4-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
  pom {:project 'cljsjs/react-debounce-input
       :version +version+
       :description "React component that renders Input with debounced onChange"
       :url "https://github.com/nkbt/react-debounce-input"
       :scm {:url "https://github.com/cljsjs/packages"}
       :license { "MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://unpkg.com/react-debounce-input@" +lib-version+ "/build/react-debounce-input.js")
             :checksum "469e3a29f9336c2b9fe1daef16151581")
   (download :url (str "https://unpkg.com/react-debounce-input@" +lib-version+ "/build/react-debounce-input.min.js")
             :checksum "e21fe1a87f098463051a58356741332c")
   (sift :move {#"^react-debounce-input\.js" "cljsjs/react-debounce-input/development/react-debounce-input.inc.js"
                #"^react-debounce-input\.min\.js" "cljsjs/react-debounce-input/production/react-debounce-input.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.react-debounce-input"
              :requires ["cljsjs.react"])
   (pom)
   (jar)))
