(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.0.4")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/pica
       :version     +version+
       :description "Resize image in browser with high quality and high speed"
       :url         "https://github.com/nodeca/pica"
       :scm         {:url "https://github.com/nodeca/pica"}
       :license     {"MIT" "https://github.com/nodeca/pica/blob/master/LICENSE"}})

(deftask package []
  (comp
   (download :url (str "https://github.com/nodeca/pica/archive/" +lib-version+ ".tar.gz")
             :checksum "f0401ef3d2c56830e17b70535ca98910"
             :decompress true
             :compression-format "gz"
             :archive-format "tar")
   (sift :move {#"^pica-[^/]+/dist/pica.js" "cljsjs/pica/development/pica.inc.js"
                #"^pica-[^/]+/dist/pica.min.js" "cljsjs/pica/development/pica.min.inc.js"}
         :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.pica")
   (pom)
   (jar)))
