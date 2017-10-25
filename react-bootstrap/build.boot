(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces "0.1.13" :scope "test"]
                  [cljsjs/boot-cljsjs "0.8.1" :scope "test"]
                  [cljsjs/react "15.5.4-1"]
                  [cljsjs/bootstrap "3.3.6-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.31.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-bootstrap
       :version     +version+
       :description "The most popular front-end framework, rebuilt for React."
       :url         "https://react-bootstrap.github.io/index.html"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://raw.githubusercontent.com/react-bootstrap/react-bootstrap/master/LICENSE"}})

(deftask download-react-bootstrap []
  (download :url      (format "https://github.com/react-bootstrap/react-bootstrap-bower/archive/v%s.zip" +lib-version+)
            :checksum "6986def199499c35108d8267ab539460" ;;MD5
            :unzip    true))

(deftask package []
  (comp
    (download-react-bootstrap)
    (sift :move {#"^react-bootstrap-bower-.*/react-bootstrap.js"
                 "cljsjs/react-bootstrap/development/react-bootstrap.inc.js"
                 #"^react-bootstrap-bower-.*/react-bootstrap.min.js"
                 "cljsjs/react-bootstrap/production/react-bootstrap.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-bootstrap"
               :requires ["cljsjs.react.dom"])
    (pom)
    (jar)))
