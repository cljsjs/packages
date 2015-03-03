(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.4.6" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "2.0-0")

(task-options!
 pom  {:project     'cljsjs/stripe
       :version     +version+
       :description "Stripe js ext lib"
       :url         "https://stripe.com/docs/stripe.js"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Stripe  ToS" "https://stripe.com/us/terms"}})

