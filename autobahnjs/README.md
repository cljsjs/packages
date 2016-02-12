# cljsjs/autobahnjs

ClojureScript wrapper for [Autobahn|JS](http://autobahn.ws/js/) 
[](dependency)
```clojure
[cljsjs/autobahnjs "0.9.9-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:


```clojure
(ns your-ns
  (:require [cljsjs.autobahnjs]))
             
(def ^:private ab js/autobahn)

(defn create-connection
    [config]
    (ab.Connection. (clj->js config))
    
(.open (:connection (create-connection {:ws-uri        "ws://localhost.de:8280/ws"
                                        :realm         "tour"
                                        :debug?        true
                                        :reconnect?    false})))

```


[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
