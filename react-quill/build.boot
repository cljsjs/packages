(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]
                  [cljsjs/quill "0.20.0-0"]
                  [cljsjs/react "0.13.3-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.3.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-quill
       :version     +version+
       :description "A Quill component for React."
       :url         "http://zenoamaro.github.io/react-quill/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://raw.githubusercontent.com/zenoamaro/react-quill/master/LICENSE"}})

(deftask download-react-quill []
  (download :url      (str "https://github.com/zenoamaro/react-quill/archive/v" +lib-version+ ".zip")
            :checksum "869f08c94b370b48b1023de28cb092e4"
            :unzip    true))

(deftask package []
  (comp
    (download-react-quill)
    (sift :move {#"^react-quill-.*/dist/react-quill.js"
                 "cljsjs/react-quill/development/react-quill.inc.js"
                 #"^react-quill-.*/dist/react-quill.min.js"
                 "cljsjs/react-quill/production/react-quill.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-quill"
               :requires ["cljsjs.quill" "cljsjs.react"])
    (pom)
    (jar)))
