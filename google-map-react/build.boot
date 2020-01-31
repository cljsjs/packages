(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                   [cljsjs/react "15.4.0-0"]
                   [cljsjs/react-dom "15.4.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.22.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  push {:ensure-clean false}
  pom  {:project     'cljsjs/google-map-react
         :version     +version+
         :description "universal google map react component, allows render react components on the google map"
         :url         "http://istarkov.github.io/google-map-react/map/main/"
         :license     {"MIT" "http://www.opensource.org/licenses/mit-license.php"}
         :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp

    (download :url (str "https://unpkg.com/google-map-react@" +lib-version+ "/dist/GoogleMapReact.js")
      :checksum "DAC56A1D41B6A557855F6C11E93E4FE5"
      :unzip false)

    (download :url (str "https://unpkg.com/google-map-react@" +lib-version+ "/dist/GoogleMapReact.min.js")
      :checksum "D19AAD87922C7CEBF2DF60E703324E9C"
      :unzip false)

    (sift :move {#"^GoogleMapReact.js$"     "cljsjs/google-map-react/development/google-map-react.inc.js"
                  #"^GoogleMapReact.min.js$" "cljsjs/google-map-react/production/google-map-react.min.inc.js"})

    (sift :include #{#"cljsjs"})

    (deps-cljs :name "cljsjs.google-map-react"
      :requires ["cljsjs.react"
                  "cljsjs.react.dom"])

    (pom)

    (jar)))
