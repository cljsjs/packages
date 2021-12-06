# cljsjs/leaflet-event-forwarder

A plugin for leaflet v1^.

Catches unhandled canvas layer events and re-dispatches them to the next layer in the stack.

https://github.com/danwild/leaflet-event-forwarder

[](dependency)
```clojure
[cljsjs/leaflet-event-forwarder "0.0.3-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.leaflet-event-forwarder))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
