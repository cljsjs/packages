(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/morphdom
       :version     +version+
       :description "Fast and lightweight DOM diffing/patching (without the virtual part)"
       :url         "https://github.com/patrick-steele-idem/morphdom"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"ISC" "https://opensource.org/licenses/ISC"}})

(deftask package []
  (let [src "cljsjs/development/morphdom.inc.js"]
    (comp
      (download        :url      (str "https://github.com/patrick-steele-idem/morphdom/archive/v" +lib-version+ ".zip")
                       :checksum "daa94bdbb90ec38b7d4fa36c85fc55c0"
                       :unzip    true)
      (sift            :move     {(re-pattern (str "^morphdom-" +lib-version+ "/lib/index.js")) src})
      (replace-content :in       src
                       :out      src
                       :match    #"module.exports = morphdom;"
                       :value    "")
      (minify          :in       "cljsjs/development/morphdom.inc.js"
                       :out      "cljsjs/production/morphdom.min.js")
      (sift            :include  #{#"^cljsjs"})
      (deps-cljs       :name     "cljsjs.morphdom")
      (pom)
      (jar))))
