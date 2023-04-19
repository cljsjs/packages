(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(def +lib-version+ "2.1.4")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "linkify-%s" +lib-version+))

(task-options!
 pom  {:project     'cljsjs/linkify
       :version     +version+
       :description "Linkify is a JavaScript plugin for finding links in plain-text and converting them to HTML <a> tags."
       :url         "https://github.com/SoapBox/linkifyjs"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"GPLv3" "https://www.gnu.org/licenses/gpl-3.0.en.html"}})

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[boot.core :as boot]
         '[boot.tmpdir :as tmpd]
         '[clojure.java.io :as io]
         '[boot.util :refer [sh]])

(def url (format "https://github.com/SoapBox/linkifyjs/releases/download/v%s/linkifyjs.zip" +lib-version+))

(deftask download-linkify []
         (download :url url
                   :checksum "4d2811c0cf69b0f2be1389590c479986"
                   :unzip true))

(deftask package []
   (comp
     (download-linkify)
     (sift :move {#".*linkify.js"
                  "cljsjs/linkify/development/linkify.inc.js"
                  #".*linkify.min.js"
                  "cljsjs/linkify/production/linkify.min.inc.js"

                  #".*linkify-string.js"
                  "cljsjs/linkify/development/linkify-string.inc.js"
                  #".*linkify-string.min.js"
                  "cljsjs/linkify/production/linkify-string.min.inc.js"

                  #".*linkify-react.js"
                  "cljsjs/linkify/development/linkify-react.inc.js"
                  #".*linkify-react.min.js"
                  "cljsjs/linkify/production/linkify-react.min.inc.js"

                  #".*linkify-polyfill.js"
                  "cljsjs/linkify/development/linkify-polyfill.inc.js"
                  #".*linkify-polyfill.min.js"
                  "cljsjs/linkify/production/linkify-polyfill.min.inc.js"

                  #".*linkify-plugin-ticket.js"
                  "cljsjs/linkify/development/linkify-plugin-ticket.inc.js"
                  #".*linkify-plugin-ticket.min.js"
                  "cljsjs/linkify/production/linkify-plugin-ticket.min.inc.js"

                  #".*linkify-plugin-mention.js"
                  "cljsjs/linkify/development/linkify-plugin-mention.inc.js"
                  #".*linkify-plugin-mention.min.js"
                  "cljsjs/linkify/production/linkify-plugin-mention.min.inc.js"

                  #".*linkify-plugin-hashtag.js"
                  "cljsjs/linkify/development/linkify-plugin-hashtag.inc.js"
                  #".*linkify-plugin-hashtag.min.js"
                  "cljsjs/linkify/production/linkify-plugin-hashtag.min.inc.js"

                  #".*linkify-jquery.js"
                  "cljsjs/linkify/development/linkify-jquery.inc.js"
                  #".*linkify-jquery.min.js"
                  "cljsjs/linkify/production/linkify-jquery.min.inc.js"

                  #".*linkify-html.js"
                  "cljsjs/linkify/development/linkify-html.inc.js"
                  #".*linkify-html.min.js"
                  "cljsjs/linkify/production/linkify-html.min.inc.js"

                  #".*linkify-element.js"
                  "cljsjs/linkify/development/linkify-element.inc.js"
                  #".*linkify-element.min.js"
                  "cljsjs/linkify/production/linkify-element.min.inc.js"})

     (sift :include #{#"^cljsjs" #"^deps.cljs"})

     (pom)
     (jar)))
