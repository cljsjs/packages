(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.2" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.4.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom {:project 'cljsjs/html2canvas
       :version +version+
       :description "html2canvas - This script allows you to take 'screenshots' of webpages or parts of it, directly on the users browser. "
       :url "http://html2canvas.hertzen.com"
       :license {"MIT" "http://opensource.org/licenses/MIT"}
       :scm {:url "https://github.com/cljsjs/packages"}})

(defn cdn-ver [file]
  (str "https://cdnjs.cloudflare.com/ajax/libs/html2canvas/"
       +lib-version+ "/" file))

(deftask package []
  (comp
    (download :url (cdn-ver "html2canvas.js"))
    (download :url (cdn-ver "html2canvas.min.js"))
    (sift :move
          {#"html2canvas.js" "cljsjs/html2canvas/development/html2canvas.inc.js"
           #"html2canvas.min.js" "cljsjs/html2canvas/production/html2canvas.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.html2canvas")
    (pom)
    (jar)))
