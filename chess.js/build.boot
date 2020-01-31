(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.10.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/chess.js
       :version     +version+
       :description "A Javascript chess library for chess move generation/validation, piece placement/movement, and check/checkmate/draw detection."
       :url         "https://github.com/jhlywa/chess.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://github.com/jhlywa/chess.js/archive/v%s.zip" +lib-version+)
             :checksum "111ec813278d3e39f66d567f7a4b1483"
             :unzip true)
   (sift :move {#".*chess\.min\.js$"   "cljsjs/chess.js/production/chess.min.inc.js"})
   (sift :move {#".*chess\.js$"   "cljsjs/chess.js/development/chess.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.chess.js")
   (pom)
   (jar)))
