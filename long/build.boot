(set-env!
 :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "3.0.1")
(def +version+ (str +lib-version+ "-1"))

(task-options!
 pom  {:project     'cljsjs/long
       :version     +version+
       :description "A Long class for representing a 64 bit two's-complement integer value."
       :url         "https://github.com/dcodeIO/long.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"License" (format "https://raw.githubusercontent.com/dcodeIO/long.js/%s/LICENSE"
                                 +lib-version+)}})

(deftask package []
  (let [src "cljsjs/development/long.inc.js"]
    (comp
      (download :url (format "https://raw.githubusercontent.com/dcodeIO/long.js/%s/dist/long.js"
                       +lib-version+)
        :name src
        :checksum "6B58D0CBB24769F0CE7A7C0CCF240EA0"
        :unzip false)
      (download :url (format "https://raw.githubusercontent.com/dcodeIO/long.js/%s/externs/long.js"
                       +lib-version+)
        :name "cljsjs/common/long.ext.js"
        :checksum "7472385A218BA78CCCF07166F2AF76D5"
        :unzip false)
      ; here b/c dcodeio uses UMD / module declarations that GClosure doesn't know how
      ; to rewrite (uses `modules["exports"] = ...`, among other things)
      ; might be cleaner with a template, or other snazzy boot resource
      ; manipulation tools with which I'm not familiar
      (replace-content :in src :out src
        :match #"(?s)function\(global.+?\}\)\(this"
        :value "function(global, factory) { Long = factory(); })(this")
      (deps-cljs :name "cljsjs.long"))))
