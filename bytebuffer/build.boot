(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                 [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def lib-version "5.0.0")
(def +version+ (str lib-version "-0"))
(bootlaces! +version+)

(task-options!
 pom  {:project     'cljsjs/bytebuffer
       :version     +version+
       :description "A fast and complete ByteBuffer implementation using either ArrayBuffers in the browser or Buffers under node.js. http://dcode.io"
       :url         "https://github.com/dcodeIO/bytebuffer.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache v2" "http://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (task-options! push {:ensure-branch nil :tag false})
  (comp
   (download :url "https://raw.githubusercontent.com/dcodeIO/ByteBuffer.js/master/dist/bytebuffer.js"
             :checksum "856E355AA41A41C1D5AC32D2CABEFBEE")
   (download :url "https://raw.githubusercontent.com/dcodeIO/ByteBuffer.js/master/dist/bytebuffer.min.js"
             :checksum "30402EFF7CC5252E141E95E48DA4622B")
   (sift :move {#"^bytebuffer\.js" "cljsjs/bytebuffer/development/bytebuffer.inc.js"
                #"^bytebuffer\.min\.js" "cljsjs/bytebuffer/development/bytebuffer.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.bytebuffer")))
