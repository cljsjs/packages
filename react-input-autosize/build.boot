(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.7.1"  :scope "test"]
                  [cljsjs/react "15.6.1-1"]
                  [cljsjs/prop-types "15.5.10-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-input-autosize
       :version     +version+
       :description "Auto-resizing input field for React"
       :url         "http://jedwatson.github.io/react-input-autosize/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (format "https://unpkg.com/react-input-autosize@%s/dist/react-input-autosize.js" +lib-version+))
    (download :url (format "https://unpkg.com/react-input-autosize@%s/dist/react-input-autosize.min.js" +lib-version+))

    (sift :move {#"^react-input-autosize.js$"      "cljsjs/react-input-autosize/development/react-input-autosize.inc.js"
	         #"^react-input-autosize.min\.js$" "cljsjs/react-input-autosize/production/react-input-autosize.min.inc.js"})

    (sift :include #{#"^cljsjs"})
    (deps-cljs :provides ["react-input-autosize" "cljsjs.react-input-autosize"]
               :requires ["react" "prop-types"]
               :global-exports '{react-input-autosize AutosizeInput})
    (pom)
    (jar)))
