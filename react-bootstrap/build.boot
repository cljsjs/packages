(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces "0.1.11" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]
                  [cljsjs/react-with-addons "0.13.1-0"]
                  [org.webjars.bower/bootstrap "3.3.4"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.23.5-0")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/react-bootstrap
       :version     +version+
       :description "The most popular front-end framework, rebuilt for React."
       :url         "https://react-bootstrap.github.io/index.html"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://raw.githubusercontent.com/react-bootstrap/react-bootstrap/master/LICENSE"}})

(deftask download-react-bootstrap []
  (download :url      "https://github.com/react-bootstrap/react-bootstrap-bower/archive/v0.23.5.zip"
            :checksum "9A9E75C382CFED0BA7B15E9CC8ADE4FF"
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
               :requires ["cljsjs.react"])))
