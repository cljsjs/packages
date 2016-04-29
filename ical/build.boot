(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.2.1")
(def +version+ (str +lib-version+ "-2"))

(task-options!
 pom  {:project     'cljsjs/ical
       :version     +version+
       :description (str "Javascript parser for ics (rfc5545) " 
                         "and vcard (rfc6350) data")
       :url         "https://github.com/mozilla-comm/ical.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MPL" "https://www.mozilla.org/en-US/MPL/2.0/"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/mozilla-comm/ical.js/archive/v" 
                        +lib-version+ ".zip")
              :checksum "981B7B1A0E2636BF6A8770513058079B"
              :unzip true)
    (sift :move {#"^ical\.js-([\d\.]*)/build/ical\.js" 
                 "cljsjs/ical/development/ical.inc.js"})
    (minify :in "cljsjs/ical/development/ical.inc.js" 
            :out "cljsjs/ical/production/ical.min.inc.js"
            :lang :ecmascript5)
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.ical")
    (pom)
    (jar)))
