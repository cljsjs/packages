(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]
                  [cljsjs/react       "0.13.3-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.3.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-motion
       :version     +version+
       :description "A spring that solves your animation problems."
       :url         "https://github.com/chenglou/react-motion"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask download-react-motion []
  (download :url      (format "https://github.com/chenglou/react-motion/archive/v%s.zip" +lib-version+)
            :checksum "C9C059E8BFEC88E7ABE321401011CA9B"
            :unzip    true))

(deftask package []
  (comp
    (download-react-motion)
    (sift :move {#"^react-.*/build/react-motion.js"
                 "cljsjs/react-motion/development/react-motion.inc.js"})
    (minify :in "cljsjs/react-motion/development/react-motion.inc.js"
            :out "cljsjs/react-motion/production/react-motion.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.react-motion"
               :requires ["cljsjs.react"])))
