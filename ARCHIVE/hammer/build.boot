(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.0.8")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/hammer
       :version     +version+
       :description "A javascript library for multi-touch gestures"
       :url         "http://hammerjs.github.io/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/hammerjs/hammer.js/archive/v%s.zip" +lib-version+)
              :checksum "43A872327E6BB626902D5C9554A7C2A0"
              :unzip true)
    (sift :move {#"^hammer.js-\d\.\d\.\d/hammer.js$"     "cljsjs/development/hammer.inc.js"
                 #"^hammer.js-\d\.\d\.\d/hammer.min.js$" "cljsjs/production/hammer.min.inc.js"})
    (replace-content :in "cljsjs/production/hammer.min.inc.js" :match #"(?m)^//# sourceMappingURL=.*$" :value "")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.hammer")
    (pom)
    (jar)))
