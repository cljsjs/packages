(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.2.2")
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
    (download :url (format "https://raw.githubusercontent.com/components/jsdiff/v%s/diff.js" +lib-version+)
              :checksum "791A9A054D1EC2A2C2906B469DDD3501")
    (download :url (format "https://raw.githubusercontent.com/components/jsdiff/v%s/diff.min.js" +lib-version+)
              :checksum "CB44DC0C341E04CA6623B296E7BC4C63")
    (sift :move {#"^diff.js$" "cljsjs/development/jsdiff.inc.js"
                 #"^diff.min.js$" "cljsjs/production/jsdiff.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.jsdiff")
    (pom)
    (jar)))
