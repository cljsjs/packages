(set-env!
 :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]
                 [cljsjs/long "3.0.3-1"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "5.0.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 push {:ensure-clean false}
 pom  {:project     'cljsjs/bytebuffer
       :version     +version+
       :description "A fast and complete ByteBuffer implementation using either ArrayBuffers in the browser or Buffers under node.js."
       :url         "https://github.com/dcodeIO/bytebuffer.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"License" (format "https://raw.githubusercontent.com/dcodeIO/bytebuffer.js/%s/LICENSE"
                                 +lib-version+)}})

(deftask package []
  (let [src "cljsjs/development/bytebuffer.inc.js"]
    (comp
      (download :url (format "https://raw.githubusercontent.com/dcodeIO/bytebuffer.js/%s/dist/bytebuffer.js"
                       +lib-version+)
        :name src
        :checksum "C30EFAA953BC38BE0A354020B1CA0E34"
        :unzip false)
      (download :url (format "https://raw.githubusercontent.com/dcodeIO/bytebuffer.js/%s/externs/bytebuffer.js"
                       +lib-version+)
        :name "cljsjs/common/bytebuffer.ext.js"
        :checksum "A020921D11C1CAD4B271DDA840ADD584"
        :unzip false)
      ; here b/c dcodeio uses UMD / module declarations that GClosure doesn't know how
      ; to rewrite (uses `modules["exports"] = ...`, `require`, among other things)
      ; might be cleaner with a template, or other snazzy boot resource
      ; manipulation tools with which I'm not familiar
      (replace-content :in src :out src
        :match #"(?s)function\(global.+?\}\)\(this"
        :value "function(global, factory) { ByteBuffer = factory(Long); })(this")
      (deps-cljs :name "cljsjs.bytebuffer"
        :requires ["cljsjs.long"])
      (pom)
      (jar))))
