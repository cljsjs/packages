(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.10" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.2.7-0")
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
    (download :url "https://github.com/matthewhudson/device.js/archive/master.zip"
              :checksum "C0B4DE6D1BCF1FD51C34E29ADB556D2B"
              :unzip true)
    (sift :move {#"^device\.[^\/]*/lib/device.js"      "cljsjs/device/development/device.inc.js"
                 #"^device\.[^\/]*/lib/device.min.js" "cljsjs/device/production/device.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.device")))
