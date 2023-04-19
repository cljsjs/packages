# cljsjs/zero-ex

[](dependency)
```clojure
[cljsjs/zero-ex "0.21.0-0"] ;; latest release
```
[](/dependency)

A JavaScript library for interacting with the 0x protocol
https://github.com/0xProject/0x.js

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.zero-ex))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
