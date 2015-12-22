(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "2.0-0")

(task-options!
 pom  {:project     'cljsjs/stripe
       :version     +version+
       :description "Stripe.com Javascript SDK"
       :url         "https://stripe.com/docs/stripe.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Stripe  ToS" "https://stripe.com/us/terms"}})

