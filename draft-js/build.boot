(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.10.0")
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
        :checksum "128669B3562E4650A1CE1DF62C6C3196")
      (download
        :url (format "https://unpkg.com/%s@%s/dist/%s.min.js" npm-project +lib-version+ "Draft")
        :checksum "5EA2FFE83123B9AD37DC12E379142170")
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
