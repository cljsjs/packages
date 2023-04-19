(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.2.15")
(def +version+ (str +lib-version+ "-0"))
(def +lib-folder+ (format "epubjs-%s" +lib-version+))

(task-options!
  pom {:project 'cljsjs/epubjs
       :version +version+
       :description "Enhanced eBooks in the browser"
       :url         "https://github.com/futurepress/epub.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "https://opensource.org/licenses/BSD-2-Clause"}})

(deftask download-src []
  (download :url (format "https://github.com/futurepress/epub.js/archive/v%s.zip" +lib-version+)
            :checksum "DE66DAC01780DCCA593AB7E32809CF09"
            :unzip true))
;; TODO: add lib zip


(deftask package []
  (comp
   (download-src)
   (sift :move {#".*build/epub\.js$" "cljsjs/epubjs/common/epub.inc.js"
                #".*build/epub\.min\.js$" "cljsjs/epubjs/production/epub.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.ebupjs")
   (pom)
   (jar)))
