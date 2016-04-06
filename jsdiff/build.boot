(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.2.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/jsdiff
       :version     +version+
       :description "A javascript text differencing implementation"
       :url         "https://github.com/kpdecker/jsdiff"
       :scm         {:url "https://github.com/kpdecker/jsdiff"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
    (download :url      (format "https://github.com/kpdecker/jsdiff/archive/v%s.zip" +lib-version+)
              :checksum "24f2e5bb35383a1bacbea3db0340c465"
              :unzip    true)
    (sift     :move     {#"^jsdiff-.*/diff.js"
                         "cljsjs/development/jsdiff.inc.js"})
    (minify   :in       "cljsjs/development/jsdiff.inc.js"
              :out      "cljsjs/production/jsdiff.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.jsdiff")
    (pom)
    (jar)))
