(def +lib-version+ "3.8.1")
(def +version+ (str +lib-version+ "-0"))

(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom  {:project     'cljsjs/immutable
       :version     +version+
       :description "Immutable persistent data collections for Javascript which increase efficiency and simplicity."
       :url         "http://facebook.github.io/immutable-js/"
       :scm         {:url "https://github.com/facebook/immutable-js"}
       :license     {"BSD-3-Clause" "https://github.com/facebook/immutable-js/blob/master/LICENSE"}})

(deftask package  []
  (comp
   (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/immutable/" +lib-version+  "/immutable.js")
             :checksum "460898C6D83E55DBEEE50A0A1FA5DFE2")
   (download :url (str "https://cdnjs.cloudflare.com/ajax/libs/immutable/" +lib-version+  "/immutable.min.js")
             :checksum "FB53C333CDD35F6CB10123DC2F20EBD5")
   (sift :move {#"^immutable.js$"
                "cljsjs/immutable/development/immutable.inc.js"
                #"^immutable.min.js"
                "cljsjs/immutable/production/immutable.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.immutable")
   (pom)
   (jar)))

