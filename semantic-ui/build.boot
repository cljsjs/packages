(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]
                 [cljsjs/jquery "2.1.4-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.1.8")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/semantic-ui
       :version     +version+
       :description "Semantic UI jquery behaviors."
       :url         "http://semantic-ui.com"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url      (format "https://github.com/Semantic-Org/Semantic-UI/archive/%s.zip" +lib-version+)
             :checksum "866AA64DF98E41459A9F88DADC6E8533"
             :unzip    true)
   (sift :move {(re-pattern (str "^Semantic-UI-" +lib-version+ "/dist/semantic.js$"))  "cljsjs/semantic-ui/development/semantic.inc.js"
                (re-pattern (str "^Semantic-UI-" +lib-version+ "/dist/semantic.min.js$"))  "cljsjs/semantic-ui/production/semantic.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.semantic-ui"
              :requires ["cljsjs.jquery"])
   (pom)
   (jar)))
