# cljsjs/paho

[](dependency)
```clojure
[cljsjs/paho "0.1-SNAPSHOT"] ;; first release
```
[](/dependency)

```clojure
(ns application.core
  (:require [cljsjs.paho]))
  
(defn connect []
  (let [mqtt (Paho.MQTT.Client. "test.mosquitto.org" 8080 "")
        connectOptions (js/Object.)]
        (set! (.-onConnectionLost mqtt ) (fn [reasonCode reasonMessage]
                                             (js/console.log reasonCode reasonMessage)))
        (set! (.-messageArrived mqtt ) (fn [msg]
                        (js/console.log "Topic: " (.-destinationName msg) " payload: " (.-payloadString msg))))
        (set! (.-onSuccess connectOptions) (fn [msg]
                                             (js/console.log msg)))
        (set! (.-onFailure connectOptions ) (fn [_ _ msg] (js/console.log "failure Connect: " msg)))
        (.connect mqtt connectOptions )
         mqtt))
  

```
