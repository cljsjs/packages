(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.2.7")
(def +version+ (str +lib-version+ "-0"))
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/device
       :version     +version+
       :description "Device.js makes it easy to write conditional CSS _and/or_ JavaScript based on device operating system (iOS, Android, Blackberry, Windows, Firefox OS, MeeGo, AppleTV, etc), orientation (Portrait vs. Landscape), and type (Tablet vs. Mobile)."
       :url         "https://github.com/matthewhudson/device.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url "https://github.com/matthewhudson/device.js/archive/v0.2.7.zip"
              :checksum "e629dc748e18443cec0153104d90f8d2"
              :unzip true)
    (sift :move {#"^device\.[^\/]*/lib/device.js"      "cljsjs/device/development/device.inc.js"
                 #"^device\.[^\/]*/lib/device.min.js" "cljsjs/device/production/device.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.device")))
