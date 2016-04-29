(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.2.7")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/device
       :version     +version+
       :description "Device.js makes it easy to write conditional CSS _and/or_ JavaScript based on device operating system (iOS, Android, Blackberry, Windows, Firefox OS, MeeGo, AppleTV, etc), orientation (Portrait vs. Landscape), and type (Tablet vs. Mobile)."
       :url         "https://github.com/matthewhudson/device.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
    (download :url (format "https://github.com/matthewhudson/device.js/archive/v%s.zip" +lib-version+)
              :checksum "e629dc748e18443cec0153104d90f8d2"
              :unzip true)
    (sift :move {#"^device\.[^\/]*/lib/device.js"      "cljsjs/device/development/device.inc.js"
                 #"^device\.[^\/]*/lib/device.min.js" "cljsjs/device/production/device.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.device")
    (pom)
    (jar)))
