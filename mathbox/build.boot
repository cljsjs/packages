(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])
(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.0.1") ; MathBox 1, *not* MathBox 2
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project 'cljsjs/mathbox
      :version +version+
      :description "MathBox 1: Three-dimensional, animated mathematical visualization"
      :url "https://github.com/unconed/MathBox.js/tree/legacy"
      :license {"MIT" "http://opensource.org/licenses/MIT"}
      :scm {:url "https://github.com/cljsjs/packages"}})

;; Download URLs are pinned to MathBox commit dd80272 to ensure no possible
;; breakage, since versioning is quite informal for MathBox 1.
(deftask package []
  (comp
   (download :url "https://github.com/unconed/MathBox.js/blob/dd802725b51260dcb361c65387afbb2a1e99b3ea/build/MathBox-bundle.js?raw=true"
             :name "cljsjs/mathbox/development/MathBox-bundle.inc.js"
             :checksum "1788279CD9C9CBECD68834E428E53E79")
   (download :url "https://raw.githubusercontent.com/unconed/MathBox.js/dd802725b51260dcb361c65387afbb2a1e99b3ea/build/MathBox-bundle.min.js"
             :name "cljsjs/mathbox/production/MathBox-bundle.min.inc.js"
             :checksum "9BEA602B731DEF836963EDB1D35F4D4C")
   (deps-cljs :name "cljsjs.mathbox")
   (pom)
   (jar)))
