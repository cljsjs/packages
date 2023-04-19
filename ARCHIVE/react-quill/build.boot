(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                  [cljsjs/quill "1.3.6-0"]
                  [cljsjs/react "15.6.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-quill
       :version     +version+
       :description "A Quill component for React."
       :url         "http://zenoamaro.github.io/react-quill/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://raw.githubusercontent.com/zenoamaro/react-quill/master/LICENSE"}})

(deftask download-react-quill []
  (download :url      (str "https://github.com/zenoamaro/react-quill/releases/download/v" +lib-version+ "/react-quill-" +lib-version+ ".tgz")
            :checksum "1629C6D2CBA935575776A9B127B43FCF"
            :decompress true
            :archive-format "tar"
            :compression-format "gz"))

(deftask package []
  (comp
    (download-react-quill)
    (sift :move {#"^package/dist/react-quill.js"
                 "cljsjs/react-quill/development/react-quill.inc.js"
                 #"^package/dist/react-quill.min.js"
                 "cljsjs/react-quill/production/react-quill.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-quill"
               :requires ["cljsjs.quill" "cljsjs.react"])
    (pom)
    (jar)))
