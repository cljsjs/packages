(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.1.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/bankersbox
       :version     +version+
       :description "Javascript API for a redis-like API wrapper for data storage in javascript, using localStorage as a default."
       :url         "https://github.com/twilio/BankersBox"
       :scm         {:url "https://github.com/twilio/BankersBox"}
       :license     {"BankersBox License" "https://raw.githubusercontent.com/twilio/BankersBox/master/LICENSE"}})


(deftask package []
  (comp
    (download :url (str "https://github.com/twilio/BankersBox/archive/v" +lib-version+ ".zip")
              :checksum "79D356CEC64AA3369854FB19560BA81F"
              :unzip true)
    (sift :move {#"^BankersBox-([\d\.]*)/bankersbox\.js"
                 "cljsjs/bankersbox/development/bankersbox.inc.js"})
    (minify    :in       "cljsjs/bankersbox/development/bankersbox.inc.js"
               :out      "cljsjs/bankersbox/production/bankersbox.min.inc.js")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.bankersbox")
    (pom)
    (jar)))
