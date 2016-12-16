(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.1.0")
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
              :checksum "D247D78CBD18D29EF6FB9A6CAE6526AC")
    (download :url (format "https://raw.githubusercontent.com/components/jsdiff/v%s/diff.min.js" +lib-version+)
              :checksum "4E674BF7B98A5B9FFDF2DEBE44F6D754")
    (sift :move {#"^diff.js$" "cljsjs/development/jsdiff.inc.js"
                 #"^diff.min.js$" "cljsjs/production/jsdiff.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.jsdiff")
    (pom)
    (jar)))
