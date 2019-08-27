(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.6.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/body-scroll-lock
       :version     +version+
       :description "Enables body scroll locking (for iOS Mobile and Tablet, Android, desktop Safari/Chrome/Firefox) without breaking scrolling of a target element (eg. modal/lightbox/flyouts/nav-menus)"
       :url         "https://github.com/willmcpo/body-scroll-lock"
       :license     {"MIT" "https://github.com/willmcpo/body-scroll-lock/blob/master/LICENSE"}
       :scm         {:url "https://github.com/willmcpo/body-scroll-lock"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/willmcpo/body-scroll-lock/archive/v" +lib-version+ ".zip")
             :unzip true)
   (sift :move {#".*lib/bodyScrollLock\.js"      "cljsjs/body-scroll-lock/development/bodyScrollLock.inc.js"
                #".*lib/bodyScrollLock\.min\.js" "cljsjs/body-scroll-lock/production/bodyScrollLock.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.body-scroll-lock")
   (pom)
   (jar)
   (validate-checksums)))
