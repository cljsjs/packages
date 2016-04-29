(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]
                  [cljsjs/moment "2.10.6-2"]
                  [cljsjs/react-bootstrap "0.28.1-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.0.22")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-bootstrap-datetimepicker
       :version     +version+
       :description "Datetime input widget for react-bootstrap"
       :url         "https://react-bootstrap.github.io/index.html"
       :scm         {:url "http://dev.quri.com/react-bootstrap-datetimepicker/"}
       :license     {"MIT" "https://raw.githubusercontent.com/quri/react-bootstrap-datetimepicker/master/LICENSE"}})

(deftask download-react-bootstrap-datetimepicker []
  (download :url      (format "https://github.com/quri/react-bootstrap-datetimepicker/archive/v%s.zip" +lib-version+)
            :checksum "12E82C4A9EF303D4F05A14894EE46E9E"
            :unzip    true))

(deftask package []
  (comp
    (download-react-bootstrap-datetimepicker)
    (sift :move {#"^react-bootstrap-datetimepicker-.*/dist/react-bootstrap-datetimepicker.js"
                 "cljsjs/react-bootstrap-datetimepicker/development/react-bootstrap-datetimepicker.inc.js"
                 #"^react-bootstrap-datetimepicker-.*/dist/react-bootstrap-datetimepicker.min.js"
                 "cljsjs/react-bootstrap-datetimepicker/production/react-bootstrap-datetimepicker.min.inc.js"
                 #"^react-bootstrap-datetimepicker-.*/css/bootstrap-datetimepicker.css"
                 "cljsjs/react-bootstrap-datetimepicker/common/react-bootstrap-datetimepicker.css"
                 #"^react-bootstrap-datetimepicker-.*/css/bootstrap-datetimepicker.min.css"
                 "cljsjs/react-bootstrap-datetimepicker/common/react-bootstrap-datetimepicker.min.css"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-bootstrap-datetimepicker"
               :requires ["cljsjs.react-bootstrap"
                          "cljsjs.moment"])
    (pom)
    (jar)))
