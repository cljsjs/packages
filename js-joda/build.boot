(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.9.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.5.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/js-joda
       :version     +version+
       :description "A date and time library for javascript"
       :url         "https://js-joda.github.io/js-joda/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/js-joda/js-joda/archive/v%s.zip" +lib-version+)
                :unzip true)
    (sift :move {#"^js-joda-([\d\.]+)/dist/js-joda\.js$" "cljsjs/js-joda/development/js-joda.inc.js"})
    ; these replaces are to avoid 'Parse error. identifier is a reserved word for \'char\''
    (replace-content :in "cljsjs/js-joda/development/js-joda.inc.js" :out "cljsjs/js-joda/development/js-joda.inc.js"
        :match #"convertToDigit\(char\)"
        :value "convertToDigit(char0)")
    (replace-content :in "cljsjs/js-joda/development/js-joda.inc.js" :out "cljsjs/js-joda/development/js-joda.inc.js"
        :match #"char.charCodeAt"
        :value "char0.charCodeAt")
    (minify :in  "cljsjs/js-joda/development/js-joda.inc.js"
            :out "cljsjs/js-joda/production/js-joda.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.js-joda")
    (pom)
    (jar)))
