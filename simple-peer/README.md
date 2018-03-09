# cljsjs/simple-peer

[](dependency)
```clojure
[cljsjs/simple-peer "8.2.0-0"]
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:


```clojure
(ns your-ns
  (:require [cljsjs.simple-peer]))


(defn get-simplepeer-from-window [is-initiator]
    "This example will not work since you will have to add callbacks like on-simplepeer-error etc"
  (let [simplepeer  (.SimplePeer js/window  #js  {"initiator" is-initiator "trickle" false} ) ]
    (-> simplepeer
        (.on "error" on-simplepeer-error)
        (.on "signal"  on-simplepeer-signal)
        (.on "connect" on-simplepeer-connect)
        (.on "data" on-simplepeer-data)

        )

    ))

```

See [simple-peers js github page]: https://github.com/feross/simple-peer
or example.cljs in this repo for usage instructions.


[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
