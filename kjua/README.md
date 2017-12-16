# cljsjs/kjua

[](dependency)
```clojure
[cljsjs/kjua "0.1.1-1"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.kjua))
```
Documentation for the kjua lib can be found [here](https://larsjung.de/kjua)

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
