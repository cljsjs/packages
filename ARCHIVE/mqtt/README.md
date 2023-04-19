# cljsjs/mqtt

Provides MQTT.js - a client library for the MQTT protocol, written in JavaScript for node.js and the browser.

[](dependency)
```clojure
[cljsjs/mqtt "2.13.0-0"] ;; latest release
```
[](/dependency)

```clojure
(ns application.core
  (:require [cljsjs.mqtt]))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps

## Example
```clojure
(ns application.core
  (:require [cljsjs.mqtt]))

(defn open-mqtt-client! [url]
  (let [mqtt-client (mqtt/connect url)]
    (.on mqtt-client "connect" #(.log js/console "Connection opened))
    (.on mqtt-client "close" #(.log js/console "Connection opened))
    (.on mqtt-client "error" #(.log js/console "Connection error))
    (.on mqtt-client "message" (fn [topic msg packet] (.log js/console "Got MQTT message")))))
```

## Maintenance

Bump the version number in build.boot,
The source files are downloaded from unpkg.
