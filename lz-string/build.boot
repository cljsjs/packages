(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.4.4")
(def +version+ (str +lib-version+ "-1"))

(task-options!
  pom {:project 'cljsjs/lz-string
       :version +version+
       :description "lz-string - LZ-based compression algorithm for JavaScript"
       :url "https://github.com/pieroxy/lz-string"
       :license {"MIT" "https://github.com/pieroxy/lz-string/blob/master/LICENSE.txt"}
       :scm {:url "https://github.com/cljsjs/packages"}})

(defn cdn-ver [file]
  (str "https://unpkg.com/lz-string@"
       +lib-version+ "/libs/" file))

(deftask package []
  (comp
    (download :url (cdn-ver "lz-string.js"))
    (download :url (cdn-ver "lz-string.min.js"))
    (sift :move
          {#"lz-string.js" "cljsjs/lz-string/development/lz-string.inc.js"
           #"lz-string.min.js" "cljsjs/lz-string/production/lz-string.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.lz-string")
    (pom)
    (jar)
    (validate)))
