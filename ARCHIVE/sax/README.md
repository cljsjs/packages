# cljsjs/sax

[](dependency)
```clojure
[cljsjs/sax "1.2.4-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

This package has `:global-exports` definitions so you can use it like regular namespace:

```clojure
(ns application.core
  (:require [sax :as sax]))

(let [parser (sax/parser true)]
  ...)
```
