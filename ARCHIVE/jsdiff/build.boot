(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.4.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/jsdiff
       :version     +version+
       :description "A javascript text differencing implementation"
       :url         "https://github.com/kpdecker/jsdiff"
       :scm         {:url "https://github.com/kpdecker/jsdiff"}
       :license     {"BSD" "https://github.com/kpdecker/jsdiff/blob/master/LICENSE"}})

(deftask package []
  (comp
    (download :url (format "https://raw.githubusercontent.com/components/jsdiff/v%s/diff.js" +lib-version+)
              :checksum "290BD227BCC5EFA0E0CF605B03FE4956")
    (download :url (format "https://raw.githubusercontent.com/components/jsdiff/v%s/diff.min.js" +lib-version+)
              :checksum "1C483E3623A7F9D4B9C88E84F8E12B49")
    (sift :move {#"^diff.js$" "cljsjs/development/jsdiff.inc.js"
                 #"^diff.min.js$" "cljsjs/production/jsdiff.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.jsdiff")
    (pom)
    (jar)))
