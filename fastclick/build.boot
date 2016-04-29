(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.0.6")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/fastclick
       :version     +version+
       :description "Polyfill to remove click delays on browsers with touch UIs"
       :url         "https://github.com/ftlabs/fastclick"
       :scm         {:url "https://github.com/ftlabs/fastclick"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/ftlabs/fastclick/archive/v%s.zip" +lib-version+)
              :checksum "E607A3ADC8C45423F16B912C94789C84"
              :unzip true)
    (sift :move {#"^fastclick-.*/lib/fastclick\.js" "cljsjs/fastclick/development/fastclick.inc.js"})
    (minify :in "cljsjs/fastclick/development/fastclick.inc.js"
            :out "cljsjs/fastclick/production/fastclick.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.fastclick")
    (pom)
    (jar)))
