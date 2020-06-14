(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])


(def +lib-version+ "62f2e689f498f9c92dbc588c58750addec9b1654")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/google-diff-match-patch
       :version     +version+
       :description "Diff, Match and Patch Library"
       :url         "https://github.com/google/diff-match-patch/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache v2" "http://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (comp
   (download :url (format "https://github.com/google/diff-match-patch/archive/%s.zip"
                          +lib-version+)
             :checksum "66a0f0e40ce972eb7e6589ab19328a72"
             :unzip true)
   (sift :move {#"^diff-match-patch-.*?/javascript/diff_match_patch_uncompressed\.js$"
                "cljsjs/google-diff-match-patch/development/google-diff-match-patch.inc.js"})
   (sift :move {#"^diff-match-patch-.*?/javascript/diff_match_patch\.js$"
                "cljsjs/google-diff-match-patch/production/google-diff-match-patch.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.google-diff-match-patch")
   (pom)
   (jar)))
