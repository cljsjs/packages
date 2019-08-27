(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4"  :scope "test"]
                  [cljsjs/jquery "3.4.0-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.4.3")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/w2ui
       :version     +version+
       :description "JavaScript UI library for data-driven web applications"
       :url         "http://w2ui.com/web/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download
      :url (format "https://unpkg.com/w2ui@%s/w2ui-%s.min.js" +lib-version+ +lib-version+)
      :target "cljsjs/w2ui/production/w2ui.min.inc.js")
    (download
      :url (format "https://unpkg.com/w2ui@%s/w2ui-%s.js" +lib-version+ +lib-version+)
      :target "cljsjs/w2ui/development/w2ui.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.w2ui"
	           :requires ["cljsjs.jquery"])
    (pom)
    (jar)
    (validate-checksums)))
