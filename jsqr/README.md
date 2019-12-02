# cljsjs/jsqr

[](dependency)
```clojure
[cljsjs/jsqr "1.2.0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require [cljsjs.jsqr]))

(defn get-qr-code [image-data]
  (obj/get (js/jsQR (.-data image-data) (.-width image-data) (.-height image-data)) "data"))

```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
