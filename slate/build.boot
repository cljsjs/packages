(def +lib-version+ "0.31.3")
(def +version+ (str +lib-version+ "-0"))

(set-env!
 :resource-paths #{"resources"}
<<<<<<< HEAD
 :dependencies '[[cljsjs/boot-cljsjs "0.8.2" :scope "test"]
                 [adzerk/bootlaces "0.1.13" :scope "test"]
=======
 :dependencies '[[cljsjs/boot-cljsjs "0.9.0" :scope "test"]
>>>>>>> upstream/master
                 [cljsjs/immutable "3.8.1-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all]
         '[adzerk.bootlaces :refer :all])

(bootlaces! +version+)

(task-options!
 pom  {:project     'reifyhealth/slate
       :version     +version+
       :description "A completely customizable framework for building rich text editors."
       :url         "http://slatejs.org"
       :scm         {:url "https://github.com/ianstormtaylor/slate"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package  []
  (comp
   (download :url (str "https://unpkg.com/slate@" +lib-version+  "/dist/slate.js")
             :checksum "eae6213c6fe071154a6ca9868b29f688")
   (download :url (str "https://unpkg.com/slate@" +lib-version+  "/dist/slate.min.js")
             :checksum "f50c3828c0ca9040d9047612aa8745bf")
   (sift :move {#"^slate.js$"
                "reifyhealth/slate/development/slate.inc.js"
                #"^slate.min.js"
                "reifyhealth/slate/production/slate.min.inc.js"})
   (sift :include #{#"^reifyhealth"})
   (deps-cljs :name "reifyhealth.slate"
              :requires ["cljsjs.react" "cljsjs.immutable"])
   (pom)
   (jar)))
