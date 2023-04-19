(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.2.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/xxhash
       :version     +version+
       :description "Javascript implementation of xxHash"
       :url         "https://github.com/pierrec/js-xxhash"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(defn github [file]
  (str "https://raw.githubusercontent.com/pierrec/js-xxhash/v"
       +lib-version+ "/build/" file))

(deftask package []
  (comp
    (download :url (github "xxhash.js")
              :checksum "c8233af1765955f32a583dc7db7aac74")
    (download :url (github "xxhash.min.js")
              :checksum "e93af9e27a8487d223233633323ef2da")
    (sift :move {#"xxhash.js"     "cljsjs/xxhash/development/xxhash.inc.js"
                 #"xxhash.min.js" "cljsjs/xxhash/production/xxhash.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name     "cljsjs.xxhash")
    (pom)
    (jar)))
