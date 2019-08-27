(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.4" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.29.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
  pom  {:project     'cljsjs/date-fns
        :version     +version+
        :description "Modern JavaScript date utility library"
        :url         "https://github.com/date-fns/date-fns"
        :license     {"MIT" "https://kossnocorp.mit-license.org"}
        :scm         {:url "https://github.com/cljsjs/packages"}})

(deftask package []
  (comp
   (download :url (format "https://github.com/date-fns/date-fns/archive/v%s.zip" +lib-version+)
             :checksum "8113C34DAFFB509D2A7A35476B679CB0"
             :unzip true)
   (sift :move {#"^date-fns-.*/dist/date_fns.js"  "cljsjs/date-fns/development/date-fns.inc.js"
                #"^date-fns-.*/dist/date_fns.min.js"  "cljsjs/date-fns/production/date-fns.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.date-fns")
   (pom)
   (jar)))
