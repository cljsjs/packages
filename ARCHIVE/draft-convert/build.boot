(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs      "0.10.5"  :scope "test"]
                  [cljsjs/react            "16.4.0-0"]
                  [cljsjs/react-dom        "16.4.0-0"]
                  [cljsjs/react-dom-server "16.4.0-0"]
                  [cljsjs/immutable        "3.8.1-0" ]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.1.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/draft-convert
       :version     +version+
       :description "Extensibly serialize & deserialize Draft.js content with HTML"
       :url         "https://github.com/HubSpot/draft-convert"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache 2.0" "https://www.apache.org/licenses/LICENSE-2.0"}})

(defn cdn-ver [file]
  (str "https://unpkg.com/draft-convert@" +lib-version+ "/dist/" file))

(deftask package []
  (comp
    (download  :url (cdn-ver "draft-convert.js")
               :target "cljsjs/draft-convert/development/draft-convert.inc.js")
    (download  :url (cdn-ver "draft-convert.min.js")
               :target "cljsjs/draft-convert/production/draft-convert.min.inc.js")
    (deps-cljs :name "cljsjs.draft-convert"
               :requires ["cljsjs.react"
                          "cljsjs.react.dom"
                          "cljsjs.react.dom.server"
                          "cljsjs.draft-js"
                          "cljsjs.immutable"])
    (pom)
    (jar)))
