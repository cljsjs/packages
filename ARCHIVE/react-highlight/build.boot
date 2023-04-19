(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                  [cljsjs/react "16.3.2-0"]
                  [cljsjs/react-dom "16.3.2-0"]
                  [cljsjs/prop-types "15.6.0-0"]
                  [cljsjs/highlight "9.12.0-2"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.7")
(def +version+ (str +lib-version+ "-2"))
(def +lib-folder+ (format "react-highlight.js-%s" +lib-version+))

(task-options!
  pom {:project     'cljsjs/react-highlight
       :version     +version+
       :description "A simple React wrapper around the Highlight.js library"
       :url         "https://github.com/bvaughn/react-highlight.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/bvaughn/react-highlight.js/archive/" +lib-version+ ".zip")
              :unzip true)
    (sift :move {#"^react-highlight\.js-\d*\.\d*.\d*/" ""})
    (run-commands :commands [["npm" "install" "--ignore-scripts"]
                             ["npm" "install" "webpack@3.11.0"]
                             ["./node_modules/.bin/webpack" "--config" "webpack.config.js"]])
    (sift :move {#"^main\.js$" "cljsjs/react-highlight/development/react-highlight.inc.js"})
    (minify :in "cljsjs/react-highlight/development/react-highlight.inc.js"
            :out "cljsjs/react-highlight/development/react-highlight.min.inc.js")
    (sift :include #{#"^cljsjs"})

    (deps-cljs :provides ["react-highlight.js" "cljsjs.react-highlight"]
               :global-exports '{react-highlight.js Highlight}
               :requires ["react"
                          "react-dom"
                          "prop-types"
                          "highlight.js"])
    (pom)
    (jar)
    (validate)))
