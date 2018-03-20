# cljsjs/zeroxproject-connect

[](dependency)
```clojure
[cljsjs/zeroxproject-connect "0.6.6-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.zeroxproject-connect))

(def http-client (new (aget js/connect "HttpClient") "https://api.com/")
```

Uses externs generated with by [`jmmk`'s Javascript Externs Generator'](https://github.com/jmmk/javascript-externs-generator) as part of the packaging process.

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
