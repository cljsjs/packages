(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                 [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.0.1")
(def +version+ (str +lib-version+ "-0"))
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/long
       :version     +version+
       :description "A Long class for representing a 64-bit two's-complement integer value. http://dcode.io"
       :url         "https://github.com/dcodeIO/long.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache v2" "http://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (task-options! push {:ensure-branch nil :tag false})
  (comp
   (download :url "https://raw.githubusercontent.com/dcodeIO/Long.js/master/dist/long.js"
             :checksum "CDC44028B50BD163FAAA071B3523EF7C")
   (download :url "https://raw.githubusercontent.com/dcodeIO/Long.js/master/dist/long.min.js"
             :checksum "526B45CEDD3919A29994E788A4320689")
   (sift :move {#"^long\.js" "cljsjs/long/development/long.inc.js"
                #"^long\.min\.js" "cljsjs/long/development/long.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.long")))
