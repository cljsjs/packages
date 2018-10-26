(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.10.5")
(def +version+ (str +lib-version+ "-0"))

(def npm-project "draft-js")

(task-options!
  pom  {:project     'cljsjs/draft-js
        :version     +version+
        :description "A React framework for building text editors"
        :url         "https://facebook.github.io/draft-js/"
        :scm         {:url "https://github.com/cljsjs/packages"}
        :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})


(deftask package []
  (let [extern-name "draft.ext.js"
        project 'cljsjs/draft-js]
    (comp
      (download
        :url (format "https://unpkg.com/%s@%s/dist/%s.js" npm-project +lib-version+ "Draft")
        :checksum "1081430BFCF0E6B9BC80A44BC431034F")
      (download
        :url (format "https://unpkg.com/%s@%s/dist/%s.min.js" npm-project +lib-version+ "Draft")
        :checksum "DABDBCDDDE1086D77C1978F58DCF8D30")
      (sift
        :move {(re-pattern (format "^%s.js$" "Draft")) (format "cljsjs/%1$s/development/%1$s.inc.js" (name project))
               (re-pattern (format "^%s.min.js$" "Draft")) (format "cljsjs/%1$s/production/%1$s.min.inc.js" (name project))})
      (sift
        :include #{#"^cljsjs"})
      (deps-cljs
        :name "cljsjs.draft-js"
        :requires ["cljsjs.immutable"])
      (pom
        :project project
        :dependencies [['cljsjs/immutable "3.8.1-0"]])
      (jar))))
