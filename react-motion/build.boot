(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0"  :scope "test"]
                  [cljsjs/react       "0.13.3-1"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.3.0-0")
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/react-motion
       :version     +version+
       :description "A spring that solves your animation problems."
       :url         "https://github.com/chenglou/react-motion"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask download-react-motion []
  (download :url      "https://github.com/chenglou/react-motion/archive/v0.3.0.zip"
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
