(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.9" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +version+ "0.1.0-1")

(task-options!
 pom  {:project     'cljsjs/bankersbox
       :version     +version+
       :description "Javascript API for a redis-like API wrapper for data storage in javascript, using localStorage as a default."
       :url         "https://github.com/twilio/BankersBox"
       :scm         {:url "https://github.com/twilio/BankersBox"}
       :license     {"BankersBox License" "https://raw.githubusercontent.com/twilio/BankersBox/master/LICENSE"}})


(deftask package []
  (deps-cljs :name "cljsjs.bankersbox"))
