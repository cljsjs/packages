(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])


(def +lib-version+ "20121119")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/google-diff-match-patch
       :version     +version+
       :description "Diff, Match and Patch Library"
       :url         "http://code.google.com/p/google-diff-match-patch/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache v2" "http://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (comp
   (download :url (format "https://storage.googleapis.com/google-code-archive-downloads/v2/code.google.com/google-diff-match-patch/diff_match_patch_%s.zip" +lib-version+)
             :checksum "c0d22f0c04da5760ecb2c2040daa6703"
             :unzip true)
   (sift :move {#"^diff_match_patch_\d*/javascript/diff_match_patch_uncompressed\.js$" "cljsjs/google-diff-match-patch/development/google-diff-match-patch.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.google-diff-match-patch")
   (pom)
   (jar)))
