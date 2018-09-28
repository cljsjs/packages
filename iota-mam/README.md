# cljsjs/iota

[](dependency)
```clojure
[cljsjs/iota-mam "0.0.1-1"] ;; latest release
```
[](/dependency)

NOTE: at the moment it is necessary to serve the file [iota-bindings-emscripten.wasm](https://raw.githubusercontent.com/iotaledger/mam.client.js/master/lib/iota-bindings-emscripten.wasm) at the root of the appication when using this library (e.g., place it in `resources/public`) of your application.

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature of the ClojureScript compiler. After adding the above dependency to your project you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.iota-mam))
```
or
```clojure
(ns application.core
  (:require cljsjs.iota-mam-light))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
