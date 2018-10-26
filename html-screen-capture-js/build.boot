(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.10")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  pom {:project 'cljsjs/html-screen-capture-js
       :version +version+
       :description "html-screen-capture-js - A small javascript library that gets a web page, and returns a new lightweight self-contained HTML DOM document. The library removes all external file dependencies while preserving the original appearance."
       :url "https://github.com/html-screen-capture-js/html-screen-capture-js"
       :license {"MIT" "http://opensource.org/licenses/MIT"}
       :scm {:url "https://github.com/cljsjs/packages"}})

(defn cdn-ver [file]
  (str "https://unpkg.com/html-screen-capture-js@"
       +lib-version+ "/dist/" file))

(deftask package []
  (comp
    (download :url (cdn-ver "html-screen-capture.js"))
    (sift :move
          {#"html-screen-capture.js" "cljsjs/html-screen-capture/development/html-screen-capture.inc.js"})
    (minify :in "cljsjs/html-screen-capture/development/html-screen-capture.inc.js"
            :out "cljsjs/html-screen-capture/production/html-screen-capture.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.html-screen-capture-js")
    (pom)
    (jar)
    (validate-checksums)))
