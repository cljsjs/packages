(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.13.0")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/mqtt
       :version     +version+
       :description "MQTT.js is a client library for the MQTT protocol, written in JavaScript for node.js and the browser."
       :url         "https://github.com/mqttjs/MQTT.js"
       :scm         {:url "https://github.com/mqttjs/MQTT.js"}
       :license     {"MIT" "https://github.com/mqttjs/MQTT.js/blob/master/LICENSE.md"}})

(deftask package []
  (comp
   (download :url (str "https://unpkg.com/mqtt@" +lib-version+ "/dist/mqtt.js"))
   (download :url (str "https://unpkg.com/mqtt@" +lib-version+ "/dist/mqtt.min.js"))
   (sift :move {#"mqtt.js"     "cljsjs/mqtt/development/mqtt.inc.js"
                #"mqtt.min.js" "cljsjs/mqtt/production/mqtt.min.inc.js"}
         :include #{#"^cljsjs"})
   (deps-cljs :name "cljsjs.mqtt")
   (pom)
   (jar)))
