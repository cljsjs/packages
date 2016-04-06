# cljsjs/paho

[](dependency)
```clojure
[cljsjs/paho "1.0.1-0"] ;; latest release
```
[](/dependency)

Please note that the minimised version of the Paho client is not used when
enabling compile optimizations as there is a weird interaction between the
Google Closure compiler and the Eclipse Paho Javascript minimised file.

```clojure
(ns mtest.core
  (:require [cljsjs.paho]))

(enable-console-print!)

(declare client send-message)

(def topic "/cljsjs/pahotest")

(println "Hello console!")

(defn on-connect []
  (println "Connected")
  (.subscribe client topic #js {:qos 0})
  (println "Subscribed")
  (send-message "Hello MQTT!" topic 0)
  (println "Sent message."))

(defn send-message [payload destination qos]
  (let [msg (Paho.MQTT.Message. payload)]
    (set! (.-destinationName msg) destination)
    (set! (.-qos msg) qos)
    (.send client msg)))

(defn connect []
  (let [mqtt (Paho.MQTT.Client. "test.mosquitto.org" 8080 "")
        connectOptions (js/Object.)]
        (set! (.-onConnectionLost mqtt) (fn [reasonCode reasonMessage]
                                            (println reasonCode reasonMessage)))
        (set! (.-onMessageArrived mqtt) (fn [msg]
                                         (println
                                            (str  "Topic: " (.-destinationName msg)
                                                  " Payload: " (.-payloadString msg)))))
        (set! (.-onSuccess connectOptions) (fn [] (on-connect)))
        (set! (.-onFailure connectOptions ) (fn [_ _ msg] (println "Failure Connect: " msg)))
        (.connect mqtt connectOptions )
         mqtt))

(def client (connect))



```
