# cljsjs/skygear

[](dependency)
```clojure
[cljsjs/skygear "0.22.2-0"] ;; latest release
```
[](/dependency)

ClojureScript package for the [Skygear](skygear) BaaS JS SDK.

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.skygear))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
[skygear]: https://skygear.io
