(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                 [cljsjs/stripe "3.0-0"]
                 [cljsjs/react "15.6.2-4"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "6.1.2")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/react-stripe-elements
       :version     +version+
       :description "React components for Stripe.js and Stripe Elements"
       :url         "https://stripe.com/elements"
       :scm         {:url "https://github.com/stripe/react-stripe-elements"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (format "https://unpkg.com/react-stripe-elements@%s/dist/react-stripe-elements.js" +lib-version+)
             :target "cljsjs/react-stripe-elements/development/react-stripe-elements.inc.js")
   (download :url (format "https://unpkg.com/react-stripe-elements@%s/dist/react-stripe-elements.min.js" +lib-version+)
             :target "cljsjs/react-stripe-elements/production/react-stripe-elements.min.inc.js")
   (deps-cljs :name "cljsjs.react-stripe-elements"
              :requires ["cljsjs.react"])
   (pom)
   (jar)
   (validate)))
