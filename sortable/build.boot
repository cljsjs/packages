(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.3" :scope "test"]])

(def +lib-version+ "1.6.0")
(def +version+ (str +lib-version+ "-0"))

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(task-options!
 pom {:project     'cljsjs/sortable
      :version     +version+
      :description "Sortable — is a JavaScript library for reorderable drag-and-drop lists on modern browsers and touch devices. No jQuery. Supports Meteor, AngularJS, React, Polymer, Knockout and any CSS library, e.g. Bootstrap"
      :url         "http://rubaxa.github.io/Sortable/"
      :license     {"MIT" "http://opensource.org/licenses/MIT"}
      :scm         {:url "https://github.com/RubaXa/Sortable"}})

(deftask package []
  (comp
   (download :url (format "https://cdnjs.cloudflare.com/ajax/libs/Sortable/%s/Sortable.js" +lib-version+))
   (download :url (format "https://cdnjs.cloudflare.com/ajax/libs/Sortable/%s/Sortable.min.js" +lib-version+))
   (sift :move {#"Sortable.js" "cljsjs/development/sortable.inc.js"
                #"Sortable.min.js" "cljsjs/production/sortable.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.sortable")
   (pom)
   (jar)
   (validate)))
