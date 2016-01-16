(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "4.0.7")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/rx
       :version     +version+
       :description "Reactive Extensions for JavaScript (RxJS), a set of libraries for composing asynchronous and event-based programs using observable sequences and fluent query operators."
       :url         "https://github.com/Reactive-Extensions/RxJS"
       :scm         {:url "https://github.com/Reactive-Extensions/RxJS"}
       :license     {"Apache License, Version 2.0" "http://www.apache.org/licenses/LICENSE-2.0"}})

(deftask package []
  (comp
    (download :url (format "https://cdnjs.cloudflare.com/ajax/libs/rxjs/%s/rx.all.js" +lib-version+)
              :checksum "C2154D3CBA24F7011644C83C37FA7A4C")
    (download :url (format "https://cdnjs.cloudflare.com/ajax/libs/rxjs/%s/rx.all.min.js" +lib-version+)
              :checksum "EAB75742492CEAB96FE87C884642D9AF")
    (sift :move {#"rx\.all\.js" "cljsjs/rx/development/rx.inc.js"
                 #"rx\.all\.min\.js" "cljsjs/rx/production/rx.min.inc.js"})
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.rx")))
