(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.8.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/peg
       :version     +version+
       :description "PEG.js: Parser generator for JavaScript"
       :url         "http://pegjs.org/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/pegjs/pegjs/releases/download/v%s/peg-%s.js" +lib-version+)
              :checksum "992f208961e69128046411f881776c5f")
    (download :url (format "https://github.com/pegjs/pegjs/releases/download/v%s/peg-%s.min.js" +lib-version+)
              :checksum "abd4f4b562bcc818b5ef842c756f386e")
    (sift :move {#"^peg-0\.8\.0\.js"      "cljsjs/peg/development/peg.inc.js"
                 #"^peg-0\.8\.0\.min\.js" "cljsjs/peg/production/peg.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.peg")
    (pom)
    (jar)))
