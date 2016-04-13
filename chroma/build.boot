(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.5.1"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.1.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/chroma
       :version     +version+
       :description "A lightweight but powerful library for dealing with colors"
       :url "http://gka.github.io/chroma.js/"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"BSD" "http://opensource.org/licenses/BSD-3-Clause"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/gka/chroma.js/archive/v" +lib-version+ ".zip")
             :checksum "d19a64f11d845700c5e5c4a647882404"
             :unzip true)
   (sift :move {#"chroma.js" "cljsjs/chroma/development/chroma.inc.js"
                #"chroma.min.js" "cljsjs/chroma/production/chroma.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.chroma")
   (pom)
   (jar)))
