(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.13" :scope "test"]
                  [cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.3.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/prismic-io
       :version     +version+
       :description ""
       :url         "https://github.com/prismicio/javascript-kit"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache License" "https://opensource.org/licenses/Apache-2.0"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/prismicio/javascript-kit/archive/v" +lib-version+ ".zip")
              :checksum "F8FC4478779035C93FBBB56EB423A4E6"
              :unzip true)
    (sift :move {(re-pattern (str "javascript-kit-" +lib-version+ "/dist/prismic.io.js")) "cljsjs/development/prismic.io.inc.js"
                 (re-pattern (str "javascript-kit-" +lib-version+ "/dist/prismic.io.min.js")) "cljsjs/production/prismic.io.min.inc.js"}
          :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.prismic-io")
    (pom)
    (jar)))
