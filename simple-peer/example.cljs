(ns example.com
  "I just wanted to give an example of using Simple-peer with clojurescript. I don't think this code will work on it's own though."
  (:require-macros [cljs.core.async.macros :refer [go-loop go]])
  (:require [cljs.core.async :refer [chan <! go put! >! ] ]

            [cljs.core.async :as a :refer [go <! chan put!]]
            [cljsjs.simple-peer]
            [cognitect.transit :as t]
            )

  )

(defn log
  "Cljc log"
  [text & rest]
  (.log js/console text))


(def view-emit-chan (chan))
(def view-receive-chan (chan))
(def game-logic-emit-chan (chan))
(def game-logic-receive-chan (chan))

(def remote-game-logic-receive-chan (chan))
(def remote-game-logic-emit-chan (chan))

(def remote-view-emit-chan (chan))
(def remote-view-receive-chan (chan))

(def r (t/reader :json))
(def w (t/writer :json))



(def state (atom {}))

(defn event-handler-view-emit-to-gamelogic-receive []
  (go (loop []
        (let [event (<! view-emit-chan) ]
          (put! (:chan @state) event)
           (recur)
          ))
    )
  )


(defn event-handler-game-emit-to-view-receive []
  (go (loop []
        (let [event (<! game-logic-emit-chan) ]
          (put! view-receive-chan event)
          (recur)
          ))
      )
  )


(defn setup-server-channels []
  (log "setting up log channels")
  (go (loop []
        (let
            [ game-logic-event (<! game-logic-emit-chan) ]
          (put! view-receive-chan game-logic-event)
          (put! remote-view-receive-chan game-logic-event)
          (recur)
          ))
      )
  (go (loop []
        (let [  view-emit-event (<! view-emit-chan)]
          (put! game-logic-receive-chan view-emit-event)
          (recur)
          )
        ))
  (go (loop []
        (let [  remote-view-emit-event (<! remote-view-emit-chan) ]
          (put! game-logic-receive-chan remote-view-emit-event)
          (recur)
          )
        ))
  )



(defn setup-client-channels []
  (log "setting up client channels")

  (go (loop []
        (let [ view-emit-event (<! view-emit-chan)]
          (put! remote-game-logic-receive-chan view-emit-event)
          (recur)
          )
        ))
  (go (loop []
        (let [ remote-game-logic-event (<! remote-game-logic-emit-chan) ]
          (put! view-receive-chan remote-game-logic-event)
          (recur)
          )
        ))
  )




;;;;;;;;; WEB RTC LOGIC ;;;;;;;;;


(defn parse-json [data]

  (log data)
  (.parse js/JSON  data)

  )

(defn on-simplepeer-error [error]
  (put! remote-game-logic-emit-chan [:on-peer-error error])
  (put! remote-view-emit-chan [:on-peer-error error])
  )


(defn on-simplepeer-signal [signal]

  (log signal)
  (put! view-receive-chan [:on-peer-signal signal])
  )

(defn on-simplepeer-connect []
  (log "on-peer-connect")
  )

(defn on-simplepeer-data [data]

  (let [decoded-data (t/read r  data)]

    (log "on simple peer data start")
    (log decoded-data)
    (log "on simple peer data end")

    (put! remote-game-logic-emit-chan  decoded-data)
    (put! remote-view-emit-chan  decoded-data)
    )

  )



(defn get-simplepeer-from-window [is-initiator]

  (let [simplepeer  (.SimplePeer js/window  #js  {"initiator" is-initiator "trickle" false} ) ]
    (-> simplepeer
        (.on "error" on-simplepeer-error)
        (.on "signal"  on-simplepeer-signal)
        (.on "connect" on-simplepeer-connect)
        (.on "data" on-simplepeer-data)

        )

    ))



(defn send-to-simple-peer-remote [event]
  (.send (:simplepeer @state) (t/write w  event))

  )



(defn signal-to-simple-peer-remote [data]
  "This function called when the textarea is filled with connection information"
  (log data)

  (.signal (:simplepeer @state) (.parse js/JSON  data))

  )


(defn setup-server-channel-simple-peer-send []
  (go (loop []
        (let [event (<! remote-view-receive-chan) ]
          (send-to-simple-peer-remote event)
          (recur)
          ))
      )
  )

(defn setup-client-channel-simple-peer-send []
  (go (loop []
        (let [event (<! remote-game-logic-receive-chan) ]
          (send-to-simple-peer-remote event)
          (recur)
          ))
      )
  )


(defn start-simplepeer [is-initiator]

  (log "starting simple")
  (swap! state assoc :simplepeer (get-simplepeer-from-window is-initiator))

  )


(defn start-server []
  (log "starting server")
  (setup-server-channels)

  (start-simplepeer true)

  (setup-server-channel-simple-peer-send)
  )


(defn start-client []

  (log "starting client")
  (setup-client-channels)

  (start-simplepeer false)
  (setup-client-channel-simple-peer-send)

  )
